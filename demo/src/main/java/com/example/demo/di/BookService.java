package com.example.demo.di;

import com.example.demo.reflection.Book;

public class BookService {

	
	
	@Inject
	BookRepository bookRepository;
	
	public void rent(Book book) {
		System.out.println("aaaaa");
		System.out.println("bbbbb");
	}
	
}
