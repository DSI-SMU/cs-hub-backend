package com.smu.security.service;

import com.smu.security.dto.*;
import com.smu.exceptions.MyRuntimeException;
import com.smu.security.jwt.JwtTokenManager;
import com.smu.service.UserValidationService;
import com.smu.model.User;
import com.smu.model.UserRole;
import com.smu.security.mapper.UserMapper;
import com.smu.utils.ExceptionMessageAccessor;
import com.smu.utils.GeneralMessageAccessor;
import com.smu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.smu.common.Constants.FRONT_END_RESET_PASSWORD_URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	private static final String SEND_RESET_LINK_SUCCESSFUL = "send_reset_link_successful";

	private static final String EMAIL_NOT_EXIST = "email_does_not_exist";

	private static final String AUTH_UNKNOWN = "username_unknown";

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserValidationService userValidationService;

	private final GeneralMessageAccessor generalMessageAccessor;

	private final JavaMailSender mailSender;

	private final ExceptionMessageAccessor exceptionMessageAccessor;

	private final JwtTokenManager tokenManager;

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	@Override
	public Boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public RegistrationResponse registration(RegistrationRequest registrationRequest) {

		userValidationService.validateUser(registrationRequest);

		final User user = UserMapper.INSTANCE.convertToUser(registrationRequest);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserRole(UserRole.USER);

		userRepository.save(user);

		final String username = registrationRequest.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

		final User user = findByUsername(username);

		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}

	@Override
	public ResetLinkResponse sendResetPasswordLind(String email) {

		User user = findByEmail(email);

		if (Objects.isNull(user)){
			final String notExistMessage = exceptionMessageAccessor.getMessage(null, EMAIL_NOT_EXIST);
			throw new MyRuntimeException(notExistMessage);
		}

		String token = tokenManager.generateToken(user);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("noreply@smudsi.com");
		message.setTo(email);
		message.setSubject("Password Reset");
		message.setText("Click the link below to reset your password:\n\n" + FRONT_END_RESET_PASSWORD_URL + "/" + token + "\n\nIf you did not request a password reset, please ignore this email.");

		mailSender.send(message);
		final String sendResetLinkSuccessMessage = generalMessageAccessor.getMessage(null, SEND_RESET_LINK_SUCCESSFUL, email);

		return new ResetLinkResponse(sendResetLinkSuccessMessage);
	}

	@Override
	public ResetPasswordResponse resetPassword(ResetPasswordRequest resetPasswordRequest) {
		String message;
		String password = resetPasswordRequest.getPassword();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.isAuthenticated()) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof UserDetails userDetails) {
				String username = userDetails.getUsername();

				User user = findByUsername(username);
				user.setPassword(bCryptPasswordEncoder.encode(password));
				userRepository.save(user);
				message = "Reset Password Successfully!";
			} else {
				log.error("Authentication principal is not an instance of UserDetails.");
				throw new MyRuntimeException("Unable to get user details for password reset.");
			}
		} else {
			log.error("Authentication object was null or not authenticated.");
			throw new MyRuntimeException("User is not authenticated.");
		}

		return new ResetPasswordResponse(message);
	}
}
