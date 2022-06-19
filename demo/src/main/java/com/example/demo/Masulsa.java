package com.example.demo;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import static net.bytebuddy.matcher.ElementMatchers.*;

import java.io.File;
import java.io.IOException;

public class Masulsa {

	public static void main(String[] args) {
		ClassLoader classLoader = Masulsa.class.getClassLoader();
		TypePool typePool = TypePool.Default.of(classLoader);
		
		try {
			new ByteBuddy().redefine(typePool.describe("com.example.demo.Moja").resolve(), 
					ClassFileLocator.ForClassLoader.of(classLoader))
			.method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
			.make().saveIn(new File("C://stream_excecise/demo/target/classes/com/example/demo/"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(new Moja().pullOut());
	}
	
}

