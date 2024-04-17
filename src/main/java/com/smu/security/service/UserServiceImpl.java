package com.smu.security.service;

import com.smu.dto.ResetLinkRequest;
import com.smu.security.dto.AuthenticatedUserDto;
import com.smu.security.dto.RegistrationRequest;
import com.smu.security.dto.RegistrationResponse;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.smu.common.Constants.FRONT_END_RESET_PASSWORD_URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	private static final String EMAIL_NOT_EXIST = "email_does_not_exist";

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserValidationService userValidationService;

	private final GeneralMessageAccessor generalMessageAccessor;

	private final JavaMailSender mailSender;

	private final ExceptionMessageAccessor exceptionMessageAccessor;

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
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
	public void sendResetPasswordLind(ResetLinkRequest resetLinkRequest) {
		final String email = resetLinkRequest.getEmail();

		if (!existsByEmail(email)){
			final String notExistMessage = exceptionMessageAccessor.getMessage(null, EMAIL_NOT_EXIST);
			throw new
		}

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("noreply@example.com");
		message.setTo(email);
		message.setSubject("Password Reset");
		message.setText("Click the link below to reset your password: \n{}\nIf you did not request a password reset, please ignore this email." + FRONT_END_RESET_PASSWORD_URL);

		mailSender.send(message);
	}
}
