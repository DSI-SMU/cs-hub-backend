package com.smu.security.service;

import com.smu.security.dto.*;
import com.smu.model.User;

public interface UserService {

	User findByUsername(String username);

	User findByEmail(String email);

	Boolean existsByEmail(String email);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

	ResetLinkResponse sendResetPasswordLind(String email);

	ResetPasswordResponse resetPassword(ResetPasswordRequest resetPasswordRequest);

}
