package com.bkaracan.book.service;

import com.bkaracan.book.dto.BookRequest;
import org.springframework.security.core.Authentication;

public interface BookService {

    Long save(BookRequest bookRequest, Authentication connectedUser);
}
