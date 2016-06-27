package fc.pc.second;

public class BaseObject implements Runnable {
	private int name;
	protected Storage s;
	private boolean flag = true;

	@Override
	public void run() {

	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public Storage getS() {
		return s;
	}

	public void setS(Storage s) {
		this.s = s;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
