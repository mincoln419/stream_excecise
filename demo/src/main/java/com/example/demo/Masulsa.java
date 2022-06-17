package com.example.demo;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import static net.bytebuddy.matcher.ElementMatchers.*;

import java.io.File;
import java.io.IOException;

public class Masulsa {

	public static void main(String[] args) {
//		try {
//			new ByteBuddy().redefine(Moja.class)
//			.method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
//			.make().saveIn(new File("C://stream_excecise/demo/target/classes/"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		System.out.println(new Moja().pullOut());
	}
	
}

