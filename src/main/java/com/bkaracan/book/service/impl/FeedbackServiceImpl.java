package com.bkaracan.book.service.impl;

import com.bkaracan.book.dto.request.FeedbackRequest;
import com.bkaracan.book.entity.Book;
import com.bkaracan.book.entity.Feedback;
import com.bkaracan.book.entity.User;
import com.bkaracan.book.exception.OperationNotPermittedException;
import com.bkaracan.book.mapper.FeedbackMapper;
import com.bkaracan.book.repository.BookRepository;
import com.bkaracan.book.repository.FeedbackRepository;
import com.bkaracan.book.service.FeedbackService;
import jakarta.persistence.EntityNotFoundException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class FeedbackServiceImpl implements FeedbackService {

    private final BookRepository bookRepository;
    private final FeedbackMapper feedbackMapper;
    private final FeedbackRepository feedbackRepository;

    @Override
    public Long save(FeedbackRequest request, Authentication connectedUser) {

        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new EntityNotFoundException("No book found with the ID: " + request.bookId()));
        if(book.isArchived() || !book.isShareable()) {
            throw new OperationNotPermittedException("You cannot give a feedback for an archived or not shareable book!");
        }
        User user = ((User) connectedUser.getPrincipal());
        if (Objects.equals(book.getOwner().getId(), user.getId())) {
            throw new OperationNotPermittedException("You cannot give a feedback to your own book!");
        }
        Feedback feedback = feedbackMapper.convertToEntity(request);
        return feedbackRepository.save(feedback).getId();
    }
}
