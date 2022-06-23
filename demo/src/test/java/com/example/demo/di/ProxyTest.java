package com.example.demo.di;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.jupiter.api.Test;

public class ProxyTest {

	/*
	 * BookService bookService = (BookService)
	 * Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[] {
	 * BookService.class }, new InvocationHandler() { BookService bookService = new
	 * BookService();
	 * 
	 * @Override public Object invoke(Object proxy, Method method, Object[] args)
	 * throws Throwable {
	 * 
	 * System.out.println("aaaaaaaaaaaaaaaaaaa");
	 * 
	 * return method.invoke(bookService, args); } });
	 */
	@Test
	public void rent() {

	}

}
