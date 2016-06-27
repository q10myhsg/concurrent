package test.fc.concurrent;

import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
	private ReentrantLock lock = null;
	public int data = 100; // 用于线程同步访问的共享数据

	public LockExample() {
		lock = new ReentrantLock();
	}

	public ReentrantLock getLock() {
		return lock;
	}

	public void testReentry() {
		lock.lock();
		Calendar now = Calendar.getInstance();
		System.out.println(now.getTime() + " " + Thread.currentThread() + " get lock.");
	}

	// 线程调用的方法
	public void testRun() throws Exception {
		lock.lock();

		Calendar now = Calendar.getInstance();
		try {
			// 获取锁后显示 当前时间 当前调用线程 共享数据的值（并使共享数据 + 1）
			System.out.println(now.getTime() + " " + Thread.currentThread() + " accesses the data " + data++);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		LockExample tester = new LockExample();
		tester.testReentry();
		tester.testReentry();
		tester.testReentry();
		tester.testReentry();
		// 释放重入测试的锁，要按重入的数量解锁，否则其他线程无法获取该锁。
		tester.getLock().unlock();
		tester.getLock().unlock();
		tester.getLock().unlock();	
		tester.getLock().unlock();	
		
//		System.exit(0);
	}

}

// 工作线程，调用TestServer.testRun
class workerThread implements Runnable {

	private LockExample tester = null;

	public workerThread(LockExample testLock) {
		this.tester = testLock;
	}

	public void run() {
		try {
			tester.testRun();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}