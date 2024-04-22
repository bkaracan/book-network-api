package com.bkaracan.book.entity;

import com.bkaracan.book.entity.common.BaseEntity;
import com.bkaracan.book.history.BookTransactionHistory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {

    private String title;

    @Column(name = "author_name")
    private String authorName;

    private String isbn;

    private String synopsis;

    @Column(name = "book_cover")
    private String bookCover;

    @Column(name = "is_archived")
    private boolean isArchived;

    @Column(name = "is_shareable")
    private boolean isShareable;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "book")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;

}
