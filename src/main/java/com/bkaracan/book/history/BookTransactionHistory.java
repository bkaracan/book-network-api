package com.bkaracan.book.history;

import com.bkaracan.book.entity.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_transact_history")
public class BookTransactionHistory extends BaseEntity {

    private boolean isReturned;

    private boolean isReturnApproved;
}
