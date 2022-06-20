package com.example.demo.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

	public static <T> T getObject(Class<T> classType) {
		T instance = createInstance(classType);
		Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
			if(f.getAnnotation(Inject.class) !=null) {
				Object fieldInstance = createInstance(f.getType());
				f.setAccessible(true);
				try {
					f.set(instance, fieldInstance);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					new RuntimeException(e);
				}
			} 
		});
		
		return instance;
	}

	private static<T> T createInstance(Class<T> classType) {
		
			try {
				return classType.getConstructor(null).newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				new RuntimeException(e);
			}
			return null;
		
	}
	
	
}
