package com.bkaracan.book.service;

import com.bkaracan.book.dto.request.FeedbackRequest;
import org.springframework.security.core.Authentication;

public interface FeedbackService {

    public Long save(FeedbackRequest request, Authentication connectedUser);
}
