package com.bkaracan.book.repository;

import com.bkaracan.book.entity.Token;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByTokenValue(String token);
}
