package com.smu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class ResetLinkRequest {
    @NotEmpty(message = "{email_not_empty}")
    private String email;
}
