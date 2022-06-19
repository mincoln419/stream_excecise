package com.mermer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceTest {

	@Autowired
	BookService bookService;
	@Test
	void test() {
		assertThat(bookService).isNotNull();
		assertThat(bookService.bookRepository).isNotNull();
	}

}
