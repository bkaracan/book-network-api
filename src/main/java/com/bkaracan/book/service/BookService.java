package com.bkaracan.book.service;

import com.bkaracan.book.dto.request.BookRequest;
import com.bkaracan.book.dto.response.BookResponse;
import org.springframework.security.core.Authentication;

public interface BookService {

    Long save(BookRequest bookRequest, Authentication connectedUser);

    BookResponse findById(Long bookId);
}
