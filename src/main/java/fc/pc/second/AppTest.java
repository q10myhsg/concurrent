package fc.pc.second;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppTest {
	public static final int sellerCount = 5;
	public static final int buyerCount = 5;
	public static final int storageSize = 5;
	public static final int sellerSize = 10;

	public static void main(String[] args) {
		System.out.println("============" + Thread.currentThread().getName() + "=============");
		List<BaseObject> threadHome = new LinkedList<BaseObject>();
		TicketRepertory tr = new TicketRepertory();
		for (int i = 0; i < sellerCount; i++) {
			Seller s = new Seller();
			s.setName(i);
			s.setS(tr);
			threadHome.add(s);
			new Thread(s).start();
		}

		for (int i = 0; i < buyerCount; i++) {
			Buyer b = new Buyer();
			b.setName(i);
			b.setS(tr);
			threadHome.add(b);
			new Thread(b).start();
		}

		System.out.println("-----------==========-----------");
		Iterator<BaseObject> it = threadHome.iterator();
		while (it.hasNext()) {
			it.next().setFlag(false);
		}
		System.exit(0);
	}
}
