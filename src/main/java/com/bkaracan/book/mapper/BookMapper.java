package com.bkaracan.book.mapper;

import com.bkaracan.book.dto.BookRequest;
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
}
