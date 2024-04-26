package com.bkaracan.book.controller;

import com.bkaracan.book.dto.request.BookRequest;
import com.bkaracan.book.dto.response.BookResponse;
import com.bkaracan.book.dto.response.BorrowedBookResponse;
import com.bkaracan.book.dto.response.common.PageResponse;
import com.bkaracan.book.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{book-id}")
    public ResponseEntity<BookResponse> findBookById(@PathVariable("book-id") Long bookId) {

        return ResponseEntity.ok(bookservice.findById(bookId));
    }

    @GetMapping
    public ResponseEntity<PageResponse<BookResponse>> findAllBooks(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser)
    {
        return ResponseEntity.ok(bookservice.findAllBooks(page, size, connectedUser));
    }

    @GetMapping("/owner")
    public ResponseEntity<PageResponse<BookResponse>> findAllBooksByOwner(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser) {
        return ResponseEntity.ok(bookservice.findAllBooksByOwner(page, size, connectedUser));
    }

    @GetMapping("/borrowed")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllBorrowedBooks(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser) {
        return ResponseEntity.ok(bookservice.findAllBorrowedBooks(page, size, connectedUser));
    }

    @GetMapping("/returned")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllReturnedBooks(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser) {
        return ResponseEntity.ok(bookservice.findAllReturnedBooks(page, size, connectedUser));
    }

    @PutMapping("/shareable/{book-id}")
    public ResponseEntity<Long> updateShareableStatus(
            @PathVariable("book-id") Long bookId, Authentication connectedUser) {
        return ResponseEntity.ok(bookservice.updateShareableStatus(bookId, connectedUser));
    }

    @PutMapping("/archived/{book-id}")
    public ResponseEntity<Long> updateArchivedStatus(
            @PathVariable("book-id") Long bookId, Authentication connectedUser) {
        return ResponseEntity.ok(bookservice.updateArchivedStatus(bookId, connectedUser));
    }


}
