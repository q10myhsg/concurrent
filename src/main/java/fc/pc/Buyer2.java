package fc.pc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Buyer2 implements Runnable {
	String name;
	int count = 0;
	int maxCount = 100;
	private CyclicBarrier cb;

	public Buyer2(String name) {
		this.name = name;
	}

	public Buyer2(String name, CyclicBarrier cb) {
		this.name = name;
	}

	@Override
	public void run() {

		boolean flag = true;
		while (flag) {
			try {
				Integer t = TickerSellerDemo.tickets.poll();
				System.out.println("buyer\t" + name + "\tbuys ticket\t" + t);
				
				if(cb==null){
					cb = new CyclicBarrier(10);
					cb.await();
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = !TickerSellerDemo.tickets.isEmpty();
		}
	}

	public CyclicBarrier getCb() {
		return cb;
	}

	public void setCb(CyclicBarrier cb) {
		this.cb = cb;
	}
}