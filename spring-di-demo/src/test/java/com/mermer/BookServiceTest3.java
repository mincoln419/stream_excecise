package com.mermer;

import static net.bytebuddy.matcher.ElementMatchers.named;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;

public class BookServiceTest3 {

	
	@Test
	public void di_by_byteBuddy() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Class<? extends BookService> proxyClass = new ByteBuddy().subclass(BookService.class)
				.method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
					BookService bookService = new BookService();
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						System.out.println("aaaa");
						Object invoke = method.invoke(bookService, args);
						System.out.println("bbbb");
						return invoke;
					}
				}))
		.make().load(BookService.class.getClassLoader()).getLoaded();
		
		BookService bookService = proxyClass.getConstructor(null).newInstance();
		Book book = new Book();
		book.setTitle("spring");
		bookService.rent(book);
		bookService.returnBook(book);
		
	}
	
}
