package test.fc.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * java.util.concurrent.CyclicBarrier 类是一种同步机制，它能够对处理一些算法的线程实现同步。
 * 换句话讲，它就是一个所有线程必须等待的一个栅栏，直到所有线程都到达这里，然后所有线程才可以继续做其他事情。
 */

public class CyclicBarrierExample {
	public static void main(String... strings) {
		Runnable barrier1Action = new Runnable() {
			public void run() {
				
				System.out.println("BarrierAction 1 executed ");
			}
		};
		Runnable barrier2Action = new Runnable() {
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("BarrierAction 2 executed ");
			}
		};
		CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
		CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);
		CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);
		CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2, 2000);
		barrierRunnable1.start();
		barrierRunnable2.start();
	}
}

class CyclicBarrierRunnable extends Thread {
	CyclicBarrier barrier1 = null;
	CyclicBarrier barrier2 = null;
	int waitTime = 1000;

	public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
	}

	public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2, int time) {
		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
		this.waitTime = time;
	}

	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
			this.barrier1.await();
			System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
			this.barrier2.await();
			System.out.println(Thread.currentThread().getName() + " done!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}