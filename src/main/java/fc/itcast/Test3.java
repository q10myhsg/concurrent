//package fc.itcast;
//
//import java.util.concurrent.ConcurrentLinkedQueue;
//
//public class Test3 {
//
//	public static void main(String[] args) {
//
//		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
//		ConcurrentLinkedQueue<String> list = new ConcurrentLinkedQueue<String>();
//
//		for (int i = 0; i < 10; i++) { // 这行不能改动
//			String input = i + ""; // 这行不能改动
//			list.add(input);
//			new Thread(new ThreadTest1(list)).start();
//		}
//	}
//}
//
//// 不能改动此TestDo类
//class TestDo {
//	public static String doSome(String input) {
//
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		String output = input + ":" + (System.currentTimeMillis() / 1000);
//		return output;
//	}
//}
//
//class ThreadTest1 implements Runnable {
//	ConcurrentLinkedQueue<String> cc;
//
//	ThreadTest1(ConcurrentLinkedQueue<String> cl) {
//		cc = cl;
//	}
//
//	boolean flag = true;
//
//	@Override
//	public void run() {
//		while (flag && cc != null) {
//			synchronized (cc) {
//				if (!cc.isEmpty()) {
//					String temp = cc.remove();
//					String output = TestDo.doSome(temp);
//					System.out.println(Thread.currentThread().getName() + ":" + output);
//				}
//				flag=false;
//			}
//		}
//	}
//
//}
