package fc.itcast;

public class ItcastRunnable implements Runnable {
	String name;
	Resource<Integer> resource;
	boolean flag=true;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	ItcastRunnable(String name, Resource<Integer> r) {
		this.name = name;
		resource=r;
	}

	@Override
	public void run() {
	}

}
