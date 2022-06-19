package com.example.demo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<Book> bookClass = Book.class;

		Book book = new Book();
		Class<? extends Book> bookClassa = book.getClass();

		Class<?> bookClassb = Class.forName("com.example.demo.reflection.Book");

		Field[] fields = bookClass.getFields();

		Arrays.stream(fields).forEach(m -> System.out.println(m));

		System.out.println("===========================================");

		Arrays.stream(bookClass.getDeclaredFields()).forEach(m -> System.out.println(m));

		System.out.println("===========================================");

		Arrays.stream(bookClassa.getDeclaredFields()).forEach(m -> {
			try {
				System.out.println(m.get(book));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});

		System.out.println("===========================================");

		Arrays.stream(bookClassa.getMethods()).forEach(m -> {
			System.out.println(m);
		});

		System.out.println("===========================================");

		Arrays.stream(bookClassa.getConstructors()).forEach(m -> {
			System.out.println(m);
		});

		System.out.println("===========================================");

		System.out.println(bookClassa.getSuperclass());

		System.out.println("===========================================");

		Arrays.stream(bookClassa.getInterfaces()).forEach(m -> {
			System.out.println(m);
		});

		System.out.println("===========================================");
		Arrays.stream(bookClass.getDeclaredFields()).forEach(m -> {
			int modifires = m.getModifiers();
			System.out.println(modifires);
			
			System.out.println(Modifier.isPublic(modifires));
			System.out.println(Modifier.isPrivate(modifires));
			System.out.println(Modifier.isProtected(modifires));
		});

	}
}
