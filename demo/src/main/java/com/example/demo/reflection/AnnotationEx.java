package com.example.demo.reflection;

import java.util.Arrays;

public class AnnotationEx {

	public static void main(String[] args) {
		Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);
	}
}
