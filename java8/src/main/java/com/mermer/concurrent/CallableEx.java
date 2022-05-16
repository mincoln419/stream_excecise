package com.mermer.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableEx {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		Callable<String> hello = () -> {
			Thread.sleep(2000L);
			return "Hello";
		};
		
		Callable<String> java = () -> {
			Thread.sleep(4000L);
			return "Java";
		};
		
		Callable<String> mermer = () -> {
			Thread.sleep(1000L);
			return "mermer";
		};
		
		Future<String> helloFuture =  executorService.submit(hello);
		System.out.println(helloFuture.isDone());
		System.out.println("Started");
		

		//helloFuture.cancel(true);//interrupt하면서 종료'
		helloFuture.cancel(false);//interrupt 안함.. 그러나 값은 여전히 가져올 수 없다.
		
		//callable을 get할때까지 안기다리고 그냥 실행된다
		//System.out.println(helloFuture.get()); // 없는데 가져오라고 하면 에러남.
		
		//non-blocking call
		/*List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, mermer));// 다끝날때까지 기다림
		for(Future<String> f : futures) {
			System.out.println(f.get());
		}*/
		
		//blocking call
		String futures = executorService.invokeAny(Arrays.asList(hello, java, mermer));// 다끝날때까지 기다림
		System.out.println(futures);
		
		System.out.println(helloFuture.isDone());
		System.out.println("End");
		
		
		executorService.shutdown();
	}
}
