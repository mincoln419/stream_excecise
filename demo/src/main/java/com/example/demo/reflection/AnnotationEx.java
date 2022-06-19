package com.example.demo.reflection;

import java.util.Arrays;

public class AnnotationEx {

	public static void main(String[] args) {
		Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);
		System.out.println("==============================================");
		Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println); //inherited annoation이 붙어 있어야 확인 가능
		System.out.println("==============================================");
		Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println); //inherited annoation이 붙어 있어야 확인 가능
		System.out.println("==============================================");
		
		Arrays.stream(MyBook.class.getFields()).forEach(f-> {
			Arrays.stream(f.getAnnotations()).forEach(System.out::println);
		}); //inherited annoation이 붙어 있어야 확인 가능
		System.out.println("==============================================");
	}
}
