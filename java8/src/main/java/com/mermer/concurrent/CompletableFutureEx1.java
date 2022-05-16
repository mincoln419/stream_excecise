package com.mermer.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//외부에서 complete를 명시적으로 시킬 수 있다.
public class CompletableFutureEx1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 비동기 프로그램처럼 java가 처리 가능해짐

		ExecutorService executorService = Executors.newFixedThreadPool(4);

		Future<String> future = executorService.submit(() -> "hello");

		// TODO
		future.get();
		// ~ 받아서 처리해야함.
		// Future만으로는 비동기 방식 처리가 어려움 -> CompletableFuture 사용하면 수월해짐

		// CompletableFuture 생성하는 방법
		// 1. 객체 생성
		CompletableFuture<String> completableFuture1 = new CompletableFuture();
		completableFuture1.complete("mermer");

		// 2. static 팩토리메서드
		CompletableFuture<String> completableFuture2 = CompletableFuture.completedFuture("hello");

		// 3. runAsync, run
		CompletableFuture<Void> completableFuture3 = CompletableFuture.runAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
		});

		// 4. supplyrunAsync, run
		CompletableFuture<String> completableFuture4  = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}, executorService).thenApply(s -> {
			System.out.println(Thread.currentThread().getName());
			return s.toUpperCase();
		});
		
		//.thenRun(() -> System.out.println("hello"));
		
		//
		
		System.out.println(completableFuture4.get());

		executorService.shutdown();
	}
}
