package fc.pc;

import java.util.concurrent.BlockingQueue;

public class Consumer2 extends Consumer {

	public Consumer2(BlockingQueue<String> _bq) {
		super(_bq);
	}

	@Override
	public void run() {
		if (bq != null) {
			while (flag) {
				if (bq.size()>0) {
					bq.poll();
					printState();
				} 
			}						
			System.out.println(name+" 下班了！！！");
		}
	}

}
