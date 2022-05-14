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
			while (true) {
				System.out.println("Lamda Thread:: " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					System.out.println("exit");
					return;// interrupt 받았다고 무조건 끝나는게 아니라 요 return 때문에 종료되는 것임
				}
			}
		});

		theradLamda.start();

		System.out.println("Hello " + Thread.currentThread().getName());
		Thread.sleep(3000L);
		theradLamda.interrupt();

	}

}
