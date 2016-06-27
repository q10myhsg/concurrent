package fc.pc;

public class Buyer implements Runnable {

	String name;
	int count=0;
	int maxCount=100;

	public Buyer(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		boolean flag = true;
		while (flag) {
			Integer t = TickerSellerDemo.tickets.poll();
			System.out.println("buyer\t" + name + "\tbuys ticket\t" + t);
			flag=!TickerSellerDemo.tickets.isEmpty();
			if(flag&&count>maxCount){
				flag=false;
			}
		}
	}

}