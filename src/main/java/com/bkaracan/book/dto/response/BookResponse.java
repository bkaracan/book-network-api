package com.bkaracan.book.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {

    private Long id;

    private String title;

    private String authorName;

    private String isbn;

    private String synopsis;

    private String owner;

    private byte[] cover;

    private double rate;

    private boolean isArchived;

    private boolean isShareable;
}
