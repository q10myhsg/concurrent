package test.fc.concurrent;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingDequeExample {
	public static void main(String[] args) {
		BlockingDeque<String> bd = new LinkedBlockingDeque<String>();
		bd.addFirst("addFirst1");
		bd.addFirst("addFirst2");
		bd.addLast("addLast1");
		bd.addLast("addLast2");
		bd.offer("");
		System.out.println(bd.pollLast());
		System.out.println(bd.pollLast());
		System.out.println(bd.pollLast());
		System.out.println(bd.pollLast());
	}
}
