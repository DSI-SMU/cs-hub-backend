package com.smu.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MyRuntimeException extends RuntimeException{
    private final String errorMessage;
}
