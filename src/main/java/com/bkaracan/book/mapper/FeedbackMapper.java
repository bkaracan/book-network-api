package com.bkaracan.book.mapper;

import com.bkaracan.book.dto.request.FeedbackRequest;
import com.bkaracan.book.dto.response.FeedbackResponse;
import com.bkaracan.book.entity.Book;
import com.bkaracan.book.entity.Feedback;
import java.util.Objects;
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

    public FeedbackResponse convertToDto(Feedback feedback, Long id) {
        return FeedbackResponse.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .isOwnFeedback(Objects.equals(feedback.getCreatedBy(), id))
                .build();
    }
}
