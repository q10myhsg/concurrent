package fc.pc;

import java.util.concurrent.BlockingQueue;

public class Worker<E> implements Runnable {

	protected BlockingQueue<E> bq;
	protected String name;
	protected boolean flag= true;
	
	public Worker(BlockingQueue<E> _bq) {
		bq = _bq;
	}
	
	
	public BlockingQueue<E> getBq() {
		return bq;
	}


	public void setBq(BlockingQueue<E> bq) {
		this.bq = bq;
	}


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	@Override
	public void run() {
		if (bq != null) {
			while (flag) {
				if (bq.size() > 0) {
					bq.poll();
					printState();
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					try {
						Thread.sleep(Math.round(Math.random() * 5000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println(name+" 下班了！！！");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printState() {
		System.out.println(name + " consuming ");
	}

}
