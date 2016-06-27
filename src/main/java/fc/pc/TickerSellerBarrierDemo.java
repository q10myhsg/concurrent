package fc.pc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CyclicBarrier;

public class TickerSellerBarrierDemo {
	public static final int ticketSize = 500;
	public static final int sellerCount = 100;
	public static final int buyerCount = 10;
	public static BlockingQueue<Integer> tickets = new ArrayBlockingQueue<Integer>(ticketSize);

	static {
		for (int i = 0; i < ticketSize; i++) {
			tickets.add(i);
		}
	}

	private List<CyclicBarrier> list = new LinkedList<CyclicBarrier>();

	public TickerSellerBarrierDemo() {

	}

	public TickerSellerBarrierDemo(List<CyclicBarrier> l) {
		setList(l);
	}

	public void addCyclicBarrier(CyclicBarrier cb) {
		list.add(cb);
	}

	public static void main(String... strings) {
//		TickerSellerBarrierDemo tbd = new TickerSellerBarrierDemo();
		CyclicBarrier cb = new CyclicBarrier(10, new Runnable() {
			public void run() {
				System.out.println("executed action");
			}
		});

		for (int i = 0; i < buyerCount; i++) {
			Buyer2 b = new Buyer2(i + "", cb);
			new Thread(b).start();
		}
		

	}

	public List<CyclicBarrier> getList() {
		return list;
	}

	public void setList(List<CyclicBarrier> list) {
		this.list = list;
	}
}
