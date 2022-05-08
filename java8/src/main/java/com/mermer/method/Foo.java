package com.mermer.method;

import java.util.Arrays;
import java.util.Comparator;

public class Foo {

	public static void main(String[] args) {
		String[] names = {"mermer", "alice", "jack"};
		Arrays.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		Arrays.sort(names, String::compareToIgnoreCase);
		
		
	}
}
