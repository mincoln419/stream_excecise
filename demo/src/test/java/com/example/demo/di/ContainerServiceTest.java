package com.example.demo.di;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContainerServiceTest {

	@Test
	void get_bookRepository() {
		BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
		assertNotNull(bookRepository);
	}
	
	
	@Test
	void get_bookService() {
		BookService bookService = ContainerService.getObject(BookService.class);
		assertNotNull(bookService);
		assertNotNull(bookService.bookRepository);
	}

}
