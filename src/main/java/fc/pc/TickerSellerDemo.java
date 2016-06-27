package fc.pc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TickerSellerDemo {
	public static  final int ticketSize=500;
	public static  final int sellerCount=100;
	public static final int buyerCount=10;
	public static BlockingQueue<Integer> tickets = new ArrayBlockingQueue<Integer>(ticketSize);
	static{
		for(int i=0;i<ticketSize;i++){
			tickets.add(i);
		}
	}
	
	
	public static void main(String... strings) {		
//		for(int i=0;i<sellerCount;i++){
//			Seller s = new Seller(""+i);
//			new Thread(s).start();
//		}
		for(int i=0;i<buyerCount;i++){
			Buyer s = new Buyer(""+i);
			new Thread(s).start();
		}		
	}
}
