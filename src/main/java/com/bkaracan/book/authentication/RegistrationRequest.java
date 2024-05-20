package com.bkaracan.book.authentication;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "First name is mandatory!")
    @NotNull(message = "First name is mandatory!")
    private String firstName;

    @NotEmpty(message = "Last name is mandatory!")
    @NotNull(message = "Last name is mandatory!")
    private String lastName;

    @Email(message = "Email is not formatted!")
    @NotNull(message = "Email is mandatory!")
    @NotBlank(message = "Email is mandatory!")
    private String email;

    @NotEmpty(message = "Password is mandatory!")
    @NotNull(message = "Password is mandatory!")
    @Size(min = 8, message = "Password must be 8 characters long minimum!")
    private String password;

}
