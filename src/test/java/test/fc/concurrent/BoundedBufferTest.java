package test.fc.concurrent;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class BoundedBufferTest {

	@Test

	public void testPutTake()

	{

		final BoundedBuffer bb = new BoundedBuffer();

		int count = 10;

		final CountDownLatch c = new CountDownLatch(count * 2);

		System.out.println(new Date() + " now try to call put for " + count);

		for (int i = 0; i < count; ++i)

		{

			final int index = i;

			try {
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						try {

							bb.put(index);

							System.out.println(new Date() + "  put finished:  " + index);

						} catch (InterruptedException e) {

							e.printStackTrace();

						}

						c.countDown();

					}

				});

				t.start();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		try {

			System.out.println(new Date() + " main thread is going to sleep for 10 seconds");

			Thread.sleep(10 * 1000);

		} catch (InterruptedException e1) {

			e1.printStackTrace();

		}

		System.out.println(new Date() + " now try to take for count: " + count);

		for (int i = 0; i < count; ++i)

		{

			Thread t = new Thread(new Runnable() {

				@Override

				public void run() {

					try {

						Object o = bb.take();

						System.out.println(new Date() + " take get: " + o);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

					c.countDown();

				}

			});

			t.start();

		}

		try {

			System.out.println(new Date() + ": main thread is to wait for all threads");

			c.await();

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		System.out.println(new Date() + " all threads finished");

	}

}
