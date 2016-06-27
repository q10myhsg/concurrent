package test.fc.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

/*
 * ，接下来我们看下Atomic相关的类， 比如AtomicLong, AtomicInteger等这些； 

有了CountDownLatch,涉及到多线程同步的演示就比较容易了，接下来我们看下Atomic相关的类， 比如AtomicLong, AtomicInteger等这些；  
简单的说，这些类都是线程安全的，支持无阻塞无锁定的  
 * 
 * */
public class AtomicTest {

	@Test
	public void testAtomic() {
		final int loopcount = 10000;
		int threadcount = 10;

		final NonSafeSeq seq1 = new NonSafeSeq();
		final SafeSeq seq2 = new SafeSeq();

		final CountDownLatch l = new CountDownLatch(threadcount);

		for (int i = 0; i < threadcount; ++i) {
			final int index = i;
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < loopcount; ++j) {

						seq1.inc();
						seq2.inc();
					}

					System.out.println("finished : " + index);
					l.countDown();

				}
			}).start();
		}

		try {
			l.await();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("both have finished....");
		System.out.println("NonSafeSeq:" + seq1.get());
		System.out.println("SafeSeq with atomic: " + seq2.get());

	}
}

class NonSafeSeq {
	private long count = 0;

	public void inc() {
		count++;
	}

	public long get() {
		return count;
	}
}

class SafeSeq {
	private AtomicLong count = new AtomicLong(0);

	public void inc() {
		count.incrementAndGet();
	}

	public long get() {
		return count.longValue();
	}
}