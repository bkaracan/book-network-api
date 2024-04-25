package com.bkaracan.book.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowedBookResponse {

    private Long id;

    private String title;

    private String authorName;

    private String isbn;

    private double rate;

    private boolean isReturned;

    private boolean isReturnApproved;
}
