package com.mermer.annotation;

import java.util.Arrays;
import java.util.List;

@Burger(value = "치즈")
@Burger(value = "빅맥")
@Burger(value = "머시룸")
public class RetentionEx2 {
	public static void main(String[] args){

		Burger[] burgers = RetentionEx2.class.getDeclaredAnnotationsByType(Burger.class);
		Arrays.stream(burgers).forEach(b -> {
			System.out.println(b);
		});
		
		
		BurgerContainer burgerContainer = RetentionEx2.class.getAnnotation(BurgerContainer.class);
		Arrays.stream(burgerContainer.value()).forEach(b -> {
			System.out.println(b);
		});
	}
	

}
