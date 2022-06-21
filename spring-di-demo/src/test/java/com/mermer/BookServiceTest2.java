package com.mermer;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class BookServiceTest2 {

	
	@Test
	public void di() {
		
		MethodInterceptor handler = new MethodInterceptor() {
			
			BookService bookService = new BookService();
			
			@Override
			public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

				if(method.getName().startsWith("rent")) {
					System.out.println("intercept aaaa");
					Object invoke = method.invoke(bookService, args);
					System.out.println("intercept bbb");
					return invoke;
				}
				
				return method.invoke(bookService, args);
			}
		};
		
		BookService bookService = (BookService)Enhancer.create(BookService.class, handler);
		
		Book book = new Book();
		book.setTitle("spring");
		bookService.rent(book);
		bookService.returnBook(book);
		
	}
	
}
