package fc.itcast;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ExcutePool {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
		};
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		new Thread(future).start();
		try {
			Thread.sleep(5000);// 可能做一些事情
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> f = es.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				// Thread.sleep(1000 * 3);
				return "hello";
			}
		});

		System.out.println(f.get());
	}
}
