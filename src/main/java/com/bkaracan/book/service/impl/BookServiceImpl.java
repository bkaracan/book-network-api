package com.bkaracan.book.service.impl;

import com.bkaracan.book.dto.BookRequest;
import com.bkaracan.book.entity.Book;
import com.bkaracan.book.entity.User;
import com.bkaracan.book.mapper.BookMapper;
import com.bkaracan.book.repository.BookRepository;
import com.bkaracan.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public Long save(BookRequest bookRequest, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());
        Book book = bookMapper.convertToEntity(bookRequest);
        book.setOwner(user);
        return bookRepository.save(book).getId();
    }
}
