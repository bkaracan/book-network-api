package com.bkaracan.book;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
class BookNetworkApplicationTests {

	private final ApplicationContext context;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(context, "The application context should be loaded");
	}
}
