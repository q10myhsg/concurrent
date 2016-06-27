package fc.syc;

import java.util.LinkedList;
import java.util.List;

public class Quene<T> {
	public static final int SIZE = 100;
	List<T> l = new LinkedList<T>();

	public void add(T t) {
		synchronized (l) {
			if (l.size() + 1 == SIZE) {
				System.out.println("quene 满了 ");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				l.add(t);
				l.notify();
				
			}
		}
	}

	public T popOne() {
		T t = null;
		synchronized (l) {
			if (l.size() > 0) {
				t = l.remove(0);
			}else{
				try {
					l.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return t;
	}

	public boolean isEmpty() {
		synchronized (l) {
			return l.isEmpty();
		}
	}

}