package com.smu.security.service;

import com.smu.security.dto.AuthenticatedUserDto;
import com.smu.security.dto.RegistrationRequest;
import com.smu.security.dto.RegistrationResponse;
import com.smu.model.User;

public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
