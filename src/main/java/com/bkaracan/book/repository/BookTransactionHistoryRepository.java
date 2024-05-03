package com.bkaracan.book.repository;

import com.bkaracan.book.entity.BookTransactionHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import org.springframework.data.repository.query.Param;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory, Long> {

        @Query("""
            SELECT
            (COUNT (*) > 0) AS isBorrowed
            FROM BookTransactionHistory bookTransactionHistory
            WHERE bookTransactionHistory.user.id = :userId
            AND bookTransactionHistory.book.id = :bookId
            AND bookTransactionHistory.isReturnApproved = false
            """)
        boolean isAlreadyBorrowedByUser(@Param("bookId") Long bookId, @Param("userId") Long userId);

        @Query("""
            SELECT
            (COUNT (*) > 0) AS isBorrowed
            FROM BookTransactionHistory bookTransactionHistory
            WHERE bookTransactionHistory.book.id = :bookId
            AND bookTransactionHistory.isReturnApproved = false
            """)
        boolean isAlreadyBorrowed(@Param("bookId") Long bookId);

        @Query("""
            SELECT transaction
            FROM BookTransactionHistory  transaction
            WHERE transaction.user.id = :userId
            AND transaction.book.id = :bookId
            AND transaction.isReturned = false
            AND transaction.isReturnApproved = false
            """)
        Optional<BookTransactionHistory> findByBookIdAndUserId(@Param("bookId") Long bookId, @Param("userId") Long userId);

        @Query("""
            SELECT transaction
            FROM BookTransactionHistory  transaction
            WHERE transaction.book.owner.id = :userId
            AND transaction.book.id = :bookId
            AND transaction.isReturned = true
            AND transaction.isReturnApproved = false
            """)
        Optional<BookTransactionHistory> findByBookIdAndOwnerId(@Param("bookId") Long bookId, @Param("userId") Long userId);

        @Query("""
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.user.id = :userId
            """)
        Page<BookTransactionHistory> findAllBorrowedBooks(Pageable pageable, Long userId);
        @Query("""
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.book.owner.id = :userId
            """)
        Page<BookTransactionHistory> findAllReturnedBooks(Pageable pageable, Long userId);

}
