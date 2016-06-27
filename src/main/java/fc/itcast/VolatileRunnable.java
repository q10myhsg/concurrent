package fc.itcast;

public class VolatileRunnable implements Runnable {

	String name;
	ResourceFlag<Integer> resource;
	volatile boolean flag;

	
	public boolean isFlag() {
		return resource.getFlag();
	}

	public void setFlag(boolean flag) {
		this.flag=flag;
		resource.setFlag(flag);
	}

	public VolatileRunnable(String name, ResourceFlag<Integer> r) {
		this.name = name;
		resource=r;
		flag = r.getFlag();
	}



	@Override
	public void run() {

		while (flag) {
			
			System.out.println(Thread.currentThread().getName() + "-------- is running");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "-------- is closing=======================");
	}

}
