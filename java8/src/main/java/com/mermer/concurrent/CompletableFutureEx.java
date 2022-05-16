package com.mermer.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "hello";
		});

		CompletableFuture<String> helloWorld = hello.thenCompose(CompletableFutureEx::world);

		System.out.println(helloWorld.get());

		boolean throwError = true;
		CompletableFuture<String> java = CompletableFuture.supplyAsync(() -> {
			
			if(throwError) {
				throw new IllegalArgumentException();
			}
			
			System.out.println("java " + Thread.currentThread().getName());
			return "java";
		}).handle((result, exception) -> {//보다 general한 예외 처리 방법
			if(exception != null) {
				System.out.println(exception.getMessage());
				return "ERROR!";
			}
			return result;
		} );
		
		/*
		 * 오류처리방법
		 * .exceptionally(ex -> {
			System.out.println(ex.getMessage());
			return "Error!";
		})
		 * */
		;

		CompletableFuture<String> helloJava = hello.thenCombine(java, (h, j) -> {
			return h + " " + j;
		});
		System.out.println(helloJava.get());
		
		List<CompletableFuture> list = Arrays.asList(hello, java);
		CompletableFuture[] futures = list.toArray(new CompletableFuture[list.size()]);

		CompletableFuture<List<Object>> results =  CompletableFuture.allOf(futures).thenApply(v -> {
			return list.stream()
					.map(CompletableFuture::join)
					.collect(Collectors.toList());
		});
		
		results.get().forEach(System.out::println);
		
		CompletableFuture<Object> df =  CompletableFuture.anyOf(futures);
		System.out.println(df.get());
	}

	static private CompletableFuture<String> world(String message) {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("World " + Thread.currentThread().getName());
			return message + " World";
		});
	}
}
