package com.bkaracan.book.enumaration;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum BusinessErrorCodeEnum {

    NO_CODE(0, "No code.", NOT_IMPLEMENTED),

    INCORRECT_CURRENT_PASSWORD(300, "Current password is incorrect.", BAD_REQUEST),

    NEW_PASSWORD_DOES_NOT_MATCH(300, "The new password does not match.", BAD_REQUEST),

    ACCOUNT_LOCKED(302, "User account is locked.", FORBIDDEN),

    ACCOUNT_DISABLED(303, "User account is disabled.", FORBIDDEN),

    BAD_CREDENTIALS(304, "Login and/or password is incorrect", FORBIDDEN);

    private final int code;

    private final String description;

    private final HttpStatus httpStatus;
}
