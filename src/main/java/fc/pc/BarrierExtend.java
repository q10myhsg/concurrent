package fc.pc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierExtend {

	CyclicBarrier cb;
	int parties;
	Runnable barrierAction;

	public BarrierExtend(int parties, Runnable barrierAction) {
		cb = new CyclicBarrier(parties, barrierAction);
		this.parties = parties;
		this.barrierAction = barrierAction;
	}

	public void await() {
		if (cb != null) {
			try {
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			cb = new CyclicBarrier(parties, barrierAction);
		}
	}

}
