package fc.pc;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Worker<String> {

	public Consumer(BlockingQueue<String> _bq) {
		super(_bq);
	}

	@Override
	public void run() {
		if (bq != null) {
			while (flag) {
				if (bq.size()>0) {
					bq.poll();
					printState();

				} else {
					try {
						Thread.sleep(Math.round(Math.random() * 1000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println(name+" 下班了！！！");
		}
	}
	@Override
	public void printState() {
		System.out.println(name + " 在搬运中 ");
	}
}
