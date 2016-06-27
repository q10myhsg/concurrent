package fc.syc;

public class SycTest {

	public static int buyerCount = 10;
	public static int queueSize = 10;
	public static int sellerSize = 5;
	public static int addSize = 5;

	public static void main(String[] args) {
		Quene<Integer> q = new Quene<Integer>();
		for (int i = 0; i < queueSize; i++) {
			q.add(i);
		}

		for (int i = 0; i < buyerCount; i++) {
			Buyer<Integer> b = new Buyer<Integer>(q);
			b.setName(i + "");
			new Thread(b).start();
		}
		for (int i = 0; i < sellerSize; i++) {
			Seller s = new Seller(q);
			s.setName(i);
			s.setAddSize(addSize);
			new Thread(s).start();
		}
	}
}
