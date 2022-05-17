package com.mermer.annotation;

public class RetentionEx {
	public static void main(String[] args) {

	}
	
	static class FeelsLikeChicken<@Chicken T> {
		
		
		static public <@Chicken C> void print(C c) {//타입 파라미터, 파라미터
			
		}
	}
}
