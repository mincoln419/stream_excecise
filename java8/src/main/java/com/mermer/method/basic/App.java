package com.mermer.method.basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();
		names.add("mermer");
		names.add("hello");
		names.add("youngsun");
		names.add("eunwoo");
		names.add("mother");
		names.add("");

		// 메서드 레퍼런스
		// names.forEach(System.out::println);

		// spliterator - iterator 같은데 사용방법이 다름
		// 순서가 중요하지 않고 parellal 하게 처리하고 싶을 때 유용하다.
		// stream의 기반에 spliterator 를 사용하는 것임
		Spliterator<String> spliterator = names.spliterator();
		Spliterator<String> spliterator1 = spliterator.trySplit();
		while (spliterator.tryAdvance(System.out::println))
			;

		System.out.println("=========================");

		while (spliterator1.tryAdvance(System.out::println))
			;

		long n = names.stream()
				.map(String::toUpperCase)
				.filter(s -> s.startsWith("M"))
				.count();
		
		System.out.println(n);
		
		Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase ;
		
		names.sort(Comparator.nullsFirst(compareToIgnoreCase));
		
		System.out.println(names);

	}

}
