package com.bkaracan.book.service;

import com.bkaracan.book.dto.request.FeedbackRequest;
import com.bkaracan.book.dto.response.FeedbackResponse;
import com.bkaracan.book.dto.response.common.PageResponse;
import org.springframework.security.core.Authentication;

public interface FeedbackService {

    public Long save(FeedbackRequest request, Authentication connectedUser);

    PageResponse<FeedbackResponse> findAllFeedbackByBook(Long bookId, int page, int size, Authentication connectedUser);
}
