package fc.pc.second;

public class Buyer extends BaseObject {
	@Override
	public void run() {
		while (isFlag()) {
			int t = s.buyTicket();
			if (t > 0) {
//				System.out.println("buyer " + getName() + " buy ticket " + t);
			}
		}
	}
}
