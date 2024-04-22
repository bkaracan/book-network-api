package com.bkaracan.book.service;

import com.bkaracan.book.authentication.AuthenticationRequest;
import com.bkaracan.book.authentication.AuthenticationResponse;
import com.bkaracan.book.authentication.RegistrationRequest;
import jakarta.mail.MessagingException;

public interface AuthenticationService {

    void register(RegistrationRequest request) throws MessagingException;

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void activateAccount(String token) throws MessagingException;

}
