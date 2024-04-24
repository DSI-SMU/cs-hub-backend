package com.smu.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class ResetPasswordRequest {
    @NotEmpty(message = "{password_not_empty}")
    private String password;
}
