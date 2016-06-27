package fc.pc;

import java.util.concurrent.BlockingQueue;

public class Producer2 extends Producer {

	final int size =20;
	public Producer2(BlockingQueue<String> _bq) {
		super(_bq);
	}

	@Override
	public void run() {
		for(int i = 0;i<size;i++){
			bq.add(this.name+" putting "+this.name+i);
		}
		System.out.println(name + " 下班了！！！");
	}

}
