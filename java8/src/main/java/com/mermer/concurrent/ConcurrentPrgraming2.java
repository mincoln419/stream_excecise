package com.mermer.concurrent;

public class ConcurrentPrgraming2 {

	public static void main(String[] args) throws InterruptedException {

		// 익명클래스 활요
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Another Thread ::" + Thread.currentThread().getName());
			}
		});

		thread.start();

		// 람다식으로 변형
		Thread theradLamda = new Thread(() -> {
			System.out.println("Lamda Thread:: " + Thread.currentThread().getName());
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				throw new IllegalStateException();
			}

		});

		theradLamda.start();

		System.out.println("Hello " + Thread.currentThread().getName());

		theradLamda.join();
		System.out.println(theradLamda + " is finished");
		
		//수동으로 스레드 관리가 어려워짐..> executor가 개발되었고, 이를 사용하게 되면 future를 사용할 수 있고, 그제서야 fucture Completable을 사용할 수 있음
		

	}

}
