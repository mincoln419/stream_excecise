package com.example.demo.reflection;

@MyAnnotation("mermer_value")
public class Book {

	
	@MyAnnotation("c-book")
	public static final String c = "Book";
	@MyAnnotation("a-book")
	private String a;
	@MyAnnotation("b-book")
	public String b;
	@MyAnnotation("d-book")
	protected String d;
	
	public Book() {
	}
	
	
	public Book(String a, String b, String d) {
		super();
		this.a = a;
		this.b = b;
		this.d = d;
	}
	
	private void f() {
		System.out.println("F");
	}
	
	public void g(){
		System.out.println("G");
	}
	
	public int h() {
		return 100;
	}
	
	
	
	
}
