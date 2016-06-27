package fc.syc;

public class Seller implements Runnable {
	Quene<Integer> q;
	boolean flag = true;
	int name;
	private int addSize=10;

	public Seller(Quene<Integer> _q) {
		q = _q;
	}

	public void setName(int _name) {
		name = _name;
	}
	public int getAddSize() {
		return addSize;
	}

	public void setAddSize(int addSize) {
		this.addSize = addSize;
	}

	@Override
	public void run() {
		int start = SycTest.queueSize+name*addSize;
		for(int i = 0;i<addSize;i++){
			q.add(start+i);
			System.out.println("seller\t"+i+ "\tadd ticket\t"+(start+i));
		}
	}
}
