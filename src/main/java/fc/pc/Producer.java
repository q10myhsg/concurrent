package fc.pc;

import java.util.concurrent.BlockingQueue;

public class Producer extends Worker<String> {

	public Producer(BlockingQueue<String> _bq) {
		super(_bq);

	}

	@Override
	public void run() {
		if (bq != null) {
			while (flag) {
				if (bq.size() < 10) {
					bq.offer("");
					printState();
	
				} else {
					try {
						Thread.sleep(Math.round(Math.random() * 5000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println(name + " 下班了！！！");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void printState() {
		System.out.println(name + " 生产中 ");
	}

}
