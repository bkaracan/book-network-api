package com.bkaracan.book.mapper;

import com.bkaracan.book.dto.request.BookRequest;
import com.bkaracan.book.dto.response.BookResponse;
import com.bkaracan.book.dto.response.BorrowedBookResponse;
import com.bkaracan.book.entity.Book;
import com.bkaracan.book.entity.BookTransactionHistory;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book convertToEntity(BookRequest bookRequest) {
        return Book.builder()
                .id(bookRequest.id())
                .title(bookRequest.title())
                .authorName(bookRequest.authorName())
                .synopsis(bookRequest.authorName())
                .isArchived(false)
                .isShareable(bookRequest.isShareable())
                .build();
    }

    public BookResponse convertToDto(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .isbn(book.getIsbn())
                .synopsis(book.getSynopsis())
                .rate(book.getRate())
                .isArchived(book.isArchived())
                .isShareable(book.isShareable())
                .owner(book.getOwner().fullName())
                .build();
    }

    public BorrowedBookResponse mapForBorrowedBookResponse(BookTransactionHistory bookTransactionHistory) {

        return BorrowedBookResponse.builder()
                .id(bookTransactionHistory.getBook().getId())
                .title(bookTransactionHistory.getBook().getTitle())
                .authorName(bookTransactionHistory.getBook().getAuthorName())
                .isbn(bookTransactionHistory.getBook().getIsbn())
                .rate(bookTransactionHistory.getBook().getRate())
                .isReturned(bookTransactionHistory.isReturned())
                .isReturnApproved(bookTransactionHistory.isReturnApproved())
                .build();
    }
}
