package fc.syc;

public class Buyer<T> implements Runnable {
	Quene<T> q;
	boolean flag = true;
	String name;

	public Buyer(Quene<T> _q) {
		q = _q;
	}

	public void setName(String _name) {
		name = _name;
	}

	@Override
	public void run() {
		while (flag) {
			T t = q.popOne();
			if (t != null) {
				System.out.println("buyer\t" + name + " buy\tticket\t" + t.toString());
			} else {
//				flag = false;
				
			}
		}
		System.out.println("buyer " + name + " exits");
	}
}
