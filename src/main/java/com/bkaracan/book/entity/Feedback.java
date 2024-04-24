package com.bkaracan.book.entity;

import com.bkaracan.book.entity.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Feedback extends BaseEntity implements Serializable {

    private Double note;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
