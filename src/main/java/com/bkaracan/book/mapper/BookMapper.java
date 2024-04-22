package com.bkaracan.book.mapper;

import com.bkaracan.book.dto.request.BookRequest;
import com.bkaracan.book.dto.response.BookResponse;
import com.bkaracan.book.entity.Book;
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
}
