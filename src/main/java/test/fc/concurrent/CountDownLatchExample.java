package test.fc.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 是一个并发构造，它允许一个或多个线程等待一系列指定操作的完成 CountDownLatch
 * 以一个给定的数量初始化。countDown() 每被调用一次，这一数量就减一。 通过调用 await() 方法之一，线程可以阻塞等待这一数量到达零。
 * 这是一个并行的计数器~~~~~ 到了0就触发下一步操作,其实不是非常灵活....
 */
public class CountDownLatchExample {
	public static void main(String... strings) {
		CountDownLatch latch = new CountDownLatch(3);
		Waiter waiter = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);

		new Thread(waiter).start();
		new Thread(decrementer).start();

	}
}

class Waiter implements Runnable {

	CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Waiter Released");
	}
}

class Decrementer implements Runnable {

	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {

		try {
			Thread.sleep(500);
			this.latch.countDown();
			System.out.println(1);

			Thread.sleep(500);
			this.latch.countDown();
			System.out.println(2);
			Thread.sleep(500);
			this.latch.countDown();
			System.out.println(3);
			Thread.sleep(500);
			this.latch.countDown();
			
			System.out.println(4);
			System.out.println(this.latch.getCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}