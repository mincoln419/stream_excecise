package com.mermer.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();
		names.add("mermer");
		names.add("hello");
		names.add("youngsun");
		names.add("eunwoo");
		names.add("mother");
		names.add("");
		
		
		//stream을 만든다고 원래 내용이 바뀌는 것은 아니다.
		Stream<String> strigStream = names
				.stream()
				.map(s -> {
					System.out.println("in stream map :: " + s);//종료 operator가 나오기 전까지는 출력하지 않는다.
					return s.toUpperCase();
				});
		
		//중계 오퍼레이션 -> stream을 return 한다 map, foreach..  -> lazy 하다
		//종료 오퍼레이션 -> stream이 아닌 대상을 return 한다. reduce, collect .. -> eager 하다 
		
		System.out.println("=======================================");
		
		names.forEach(System.out::println);
		
		
		
		System.out.println("=======================================");
		//종료 오퍼레이터
		List<String> collect = strigStream.collect(Collectors.toList());
		
		
		System.out.println("=======================================");
		
		collect.forEach(System.out::println);
		
		
	}
}
