package com.bkaracan.book.spec;

import com.bkaracan.book.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    private BookSpecification() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated!");
    }

    public static Specification<Book> withOwnerId(Long ownerId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner").get("id"), ownerId);
    }
}
