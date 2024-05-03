package com.bkaracan.book.mapper;

import com.bkaracan.book.dto.request.FeedbackRequest;
import com.bkaracan.book.entity.Book;
import com.bkaracan.book.entity.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackMapper {

    public Feedback convertToEntity(FeedbackRequest request) {
        return Feedback.builder()
                .note(request.note())
                .comment(request.comment())
                .book(Book.builder()
                        .id(request.bookId())
                        .isArchived(false)
                        .isShareable(false)
                        .build())
                .build();
    }
}
