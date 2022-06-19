package com.example.demo.reflection;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<Book> bookClass = Book.class; 
		
		Book book = new Book();
		Class<? extends Book> bookClassa = book.getClass();
	
		Class<?> bookClassb = Class.forName("com.example.demo.reflection.Book");
	}
}
