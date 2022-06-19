package com.example.demo.reflection2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class<?> bookClass  = Class.forName("com.example.demo.reflection2.Book");
		
		Constructor<?> constructor =  bookClass.getConstructor(String.class);
		
		Book book = (Book) constructor.newInstance("myBook");
		System.out.println(book);
		
		Field A =  bookClass.getDeclaredField("A");
		String AString =  (String) A.get(null);
		System.out.println(AString);
		A.set(null, "AAAAAAA");
		
		String AStringChanged =  (String) A.get(null);
		System.out.println(AStringChanged);
		
		Field B  = Book.class.getDeclaredField("B");
		B.setAccessible(true);
		System.out.println(B.get(book));
		B.set(book, "BBBBBB");
		System.out.println(B.get(book));
		
		Method c = Book.class.getDeclaredMethod("c");
		c.setAccessible(true);
		c.invoke(book);
		
		Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
		int invoke = (int) sum.invoke(book, 1, 2);
		System.out.println(invoke);
	}
}
