package com.mermer.stream;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mermer.stream.vo.OnlineClass;
import com.mermer.stream.vo.Progress;

public class OptinalClass {

	public static void main(String[] args) {
		
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "spring data jpa", true));
		springClasses.add(new OnlineClass(3, "spring mvc", false));
		springClasses.add(new OnlineClass(4, "spring core", false));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		List<OnlineClass> javaClasses = new ArrayList<>();
		javaClasses.add(new OnlineClass(6, "The Java Test", true));
		javaClasses.add(new OnlineClass(7, "The Java, Code Manipulation", true));
		javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

		
		OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
		spring_boot.setProgress(Optional.of(new Progress(Duration.ofDays(1), false)));
		spring_boot.getProgress().ifPresent(c -> System.out.println(c.getStudyDuration()));
		
	}
}
