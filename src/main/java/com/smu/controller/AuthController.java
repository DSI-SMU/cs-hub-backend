package com.smu.controller;

import com.smu.security.dto.*;
import com.smu.security.jwt.JwtTokenService;
import com.smu.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

	private final JwtTokenService jwtTokenService;

	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<RegistrationResponse> registrationRequest(@Valid @RequestBody RegistrationRequest registrationRequest) {

		final RegistrationResponse registrationResponse = userService.registration(registrationRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginRequest(@Valid @RequestBody LoginRequest loginRequest) {

		final LoginResponse loginResponse = jwtTokenService.getLoginResponse(loginRequest);

		return ResponseEntity.ok(loginResponse);
	}

	@GetMapping("/reset-link/{email}")
	public ResponseEntity<ResetLinkResponse> resetLinkRequest(@Valid @PathVariable String email) {

		final ResetLinkResponse resetLinkResponse = userService.sendResetPasswordLind(email);

		return ResponseEntity.ok(resetLinkResponse);
	}

	@PostMapping("/reset-password")
	public ResponseEntity<ResetPasswordResponse> resetPasswordRequest(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {

		return ResponseEntity.ok(userService.resetPassword(resetPasswordRequest));
	}

}
