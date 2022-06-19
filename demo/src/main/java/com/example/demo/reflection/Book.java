package com.example.demo.reflection;

public class Book {

	
	public static final String c = "Book";
	private String a;
	public String b;
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
