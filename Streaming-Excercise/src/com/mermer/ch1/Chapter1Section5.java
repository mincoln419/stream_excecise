package com.mermer.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import com.mermer.ch10.User;

public class Chapter1Section5 {
	
	
	
	public static void main(String[] args) {
		
		List<User> list = new ArrayList<>();
		User user1= User.builder(201, "alice").build();
		User user2= User.builder(102, "bear").build();
		User user3= User.builder(101, "chalie").build();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		Comparator<User> nameComparator = (x, y) -> x.getName().compareTo(y.getName());
		
		Collections.sort(list, nameComparator);
		System.out.println(list);
		
		Comparator<User> idComparator = (x, y) -> x.getId() - y.getId();
		
		Collections.sort(list, idComparator);
		System.out.println(list);
		
		
	}
	
	public static <T> List<T> sort(List<T> inputs, Predicate<T> condition){
		
		
		return null;
	}
	

} 
