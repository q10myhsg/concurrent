package test.fc.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSample2 {
	static Lock lock = new ReentrantLock();
	static int count = 100;
	static int outCout = 0;
	static final int THREAD_COUNT=20;

	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();

		for (int i = 0; i < THREAD_COUNT; i++) {
			final int NO = i;
			System.out.println("thread:" + NO + " working before, poolcount:" + count);
			exec.execute(new Runnable() {
				private void lockAwhile(){
					lock.lock();
					System.out.println("I am "+NO +",I am locking");
					lock.unlock();
				}

				@Override
				public void run() {

					boolean flag = true;
					while (flag) {
						lock.lock();
						if (count > 0) {
							lockAwhile();
							count--;
							outCout++;
							System.out.println("thread:" + NO + " working , now poolcount:" + count);
						} else {
							flag = false;
						}

						lock.unlock();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

			});

		}
		System.out.println("finally poolcount:" + count + " outCout:" + outCout);
		
		exec.shutdown();
	}

}
