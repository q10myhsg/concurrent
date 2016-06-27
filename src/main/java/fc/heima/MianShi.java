package fc.heima;

public class MianShi {

	Resource r;

	public MianShi(Resource a) {
		r = a;
	}

	public void xunhuan() {

		synchronized (r) {
			if(r.flag){
				for (int i = 0; i < 5; i++) {
					System.out.println("main thread");
				}
				r.flag=false;
				r.notify();
			}else{
				try {
					r.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public static void main(String... strings) {
		Resource r = new Resource();
		MianShi ms = new MianShi(r);

		for (int i = 0; i < 50; i++) {
			new Thread(new SubTask(r)).start();
			ms.xunhuan();
		}

	}

}

class Resource {
	boolean flag=false;
}

class SubTask implements Runnable {
	Resource r;

	public SubTask(Resource a) {
		r = a;
	}

	@Override
	public void run() {
		synchronized (r) {
			if(!r.flag){
				for (int i = 0; i < 3; i++) {
					System.out.println("sub thread ");					
				}
				r.flag=true;
				r.notify();
			}else{
				try {
					r.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}