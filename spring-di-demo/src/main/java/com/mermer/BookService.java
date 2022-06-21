package com.mermer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public void rent(Book book) {
		System.out.println("rents " + book.getTitle());
	}

	public void returnBook(Book book) {
		System.out.println("return " + book.getTitle());
		
	}
	
}
