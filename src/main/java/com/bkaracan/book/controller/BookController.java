package com.bkaracan.book.controller;

import com.bkaracan.book.dto.BookRequest;
import com.bkaracan.book.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Tag(name = "Book")
public class BookController {

    private final BookService bookservice;

    @PostMapping
    public ResponseEntity<Long> saveBook(@Valid @RequestBody BookRequest bookRequest,
                                         Authentication connectedUser) {
        return ResponseEntity.ok(bookservice.save(bookRequest, connectedUser));
    }
}
