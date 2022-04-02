package com.mermer.ch9;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.mermer.ch6.Order;
import com.mermer.ch6.User;
import com.mermer.ch6.Order.OrderStatus;

public class Chapter9Section1 {

	public static void main(String[] args) {

		Supplier<String> supplier = getStringSupplier();
		System.out.println(supplier.get());
		
		BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
		//
		Function<Integer, Function<Integer, Integer>> curryAdd = x -> y -> x + y;
		Function<Integer, Integer> addThree = curryAdd.apply(3);
		int result = addThree.apply(10);
		System.out.println(result);
	}

	public static Supplier<String> getStringSupplier(){
		String hello = "Hello";
		Supplier<String> supplier = () -> {
			String world = "World";
			return hello + world;
		};
		
		return supplier;
	}
	
}
