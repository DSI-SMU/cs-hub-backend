package com.smu.security.service;

import com.smu.dto.ResetLinkResponse;
import com.smu.security.dto.AuthenticatedUserDto;
import com.smu.security.dto.RegistrationRequest;
import com.smu.security.dto.RegistrationResponse;
import com.smu.model.User;

public interface UserService {

	User findByUsername(String username);

	Boolean existsByEmail(String email);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

	ResetLinkResponse sendResetPasswordLind(String email);

}
