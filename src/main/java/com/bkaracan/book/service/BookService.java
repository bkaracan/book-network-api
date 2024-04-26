package com.bkaracan.book.service;

import com.bkaracan.book.dto.request.BookRequest;
import com.bkaracan.book.dto.response.BookResponse;
import com.bkaracan.book.dto.response.BorrowedBookResponse;
import com.bkaracan.book.dto.response.common.PageResponse;
import org.springframework.security.core.Authentication;

public interface BookService {

    Long save(BookRequest bookRequest, Authentication connectedUser);

    BookResponse findById(Long bookId);

    PageResponse<BookResponse> findAllBooks(int page, int size, Authentication connectedUser);

    PageResponse<BookResponse> findAllBooksByOwner(int page, int size, Authentication connectedUser);

    PageResponse<BorrowedBookResponse> findAllBorrowedBooks(int page, int size, Authentication connectedUser);

    PageResponse<BorrowedBookResponse> findAllReturnedBooks(int page, int size, Authentication connectedUser);

    Long updateShareableStatus(Long bookId, Authentication connectedUser);

    Long updateArchivedStatus(Long bookId, Authentication connectedUser);

    Long borrowBook(Long bookId, Authentication connectedUser);
}
