package com.mermer.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.boot.model.naming.IllegalIdentifierException;

import com.mermer.stream.vo.OnlineClass;
import com.mermer.stream.vo.Progress;

public class JavaOptionAPI {

	public static void main(String[] args) {
		
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "rest api development", false));
		
		Optional<OnlineClass> optional = springClasses.stream()
				.filter(oc -> oc.getTitle().startsWith("spring"))
				.findFirst();
		
		System.out.println(optional.isPresent());
		System.out.println(optional.isEmpty());
		
		optional.ifPresent(oc -> System.out.println(oc.getTitle()));
		//optional.orElseThrow(IllegalStateException::new);
		//OnlineClass onlineClass = optional.orElse(JavaOptionAPI::createNewClass); //optional에 값이 존재해도 무조건 수행
																					//상수로서 이미 만들어져 있는 경우라면 orElse 을 사용해도 될것
		
		OnlineClass onlineClass = optional.orElseGet(JavaOptionAPI::createNewClass);//supplier 함수를 사용하는 것으로서 실제로 값이 존재하면 lazy하게 처리되므로 수행되지 않음
		
		System.out.println(onlineClass.getTitle());
		
		Optional<Progress>  onlineClass2 = optional.filter(oc -> oc.isClosed()).flatMap(oc -> oc.getProgress());
		//System.out.println(onlineClass2);
		
	}

	
	//스프링에 있어도 발생은 한다.
	private static OnlineClass createNewClass() {
		System.out.println("Create New Class");
		return new OnlineClass(10, "New class", false);
	}
}
