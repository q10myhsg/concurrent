package test.fc.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
LinkedBlockingQueue 类实现了 BlockingQueue 接口。
LinkedBlockingQueue 内部以一个链式结构(链接节点)对其元素进行存储。如果需要的话，这一链式结构可以选择一个上限。如果没有定义上限，将使用 Integer.MAX_VALUE 作为上限。
LinkedBlockingQueue 内部以 FIFO(先进先出)的顺序对元素进行存储。队列中的头元素在所有元素之中是放入时间最久的那个，而尾元素则是最短的那个。
 * 
 * */
public class LinkedBlockingQueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBlockingQueue<String>  lbq = new LinkedBlockingQueue<String>();
		lbq.add("1");
		try {
			lbq.put("3");			
//			System.out.println(lbq.peek());
//			System.out.println(lbq.take());
//			System.out.println(lbq.take());
			System.out.println(lbq.size());
			System.out.println(lbq.poll());
			System.out.println(lbq.poll());			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
