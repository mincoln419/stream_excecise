package com.mermer.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExcecutorEx {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();//thread를 하나만쓰는 executor
		
		executorService.execute(getRunnable("Single Thread"));
		
		//executorService.shutdown();//gracefull shutdown. - 모두 다 끝내고 끝내는 method
		executorService.shutdownNow();//강제종료- 즉시 종료 (no guarantee)
		
		ExecutorService executorService2 = Executors.newFixedThreadPool(2);//n개의 thread를 쓰는 executor
		//blocking que를 사용해서 시계열 관리를 수행함!``
		
		executorService2.submit(getRunnable("hello"));
		executorService2.submit(getRunnable("java"));
		executorService2.submit(getRunnable("world"));
		executorService2.submit(getRunnable("day day"));
		executorService2.submit(getRunnable("every day"));
		
		executorService2.shutdown();
		
		ScheduledExecutorService executorService3 = Executors.newSingleThreadScheduledExecutor();//scheduled thread
		
		executorService3.schedule(getRunnable("How are you"), 3, TimeUnit.SECONDS);
		
		executorService3.scheduleAtFixedRate(getRunnable("Timely~"), 1, 2, TimeUnit.SECONDS);
		
	}

	private static Runnable getRunnable(String name) {
		return ()-> {
			System.out.println("Thread " + name + " : " + Thread.currentThread().getName());
		};
	}
	
}
