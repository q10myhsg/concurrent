package fc.pc.second;

public class Seller extends BaseObject {
	private final int size = AppTest.sellerSize;

	@Override
	public void run() {
		int start = this.getName() * size;
		for (int i = 0; i < size; i++) {
			if (!s.addTicket(start + i)) {
				i--;
			}
		}
	}
}
