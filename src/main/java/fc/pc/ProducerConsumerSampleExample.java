package fc.pc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerSampleExample {
	public static final int PRODUCER_COUNT = 5;
	public static final int CONSUER_COUNT = 10;

	public static void main(String... strings) {
		ExecutorService es = Executors.newFixedThreadPool(20);
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(50);
		// worker thread
		LinkedList<Producer> lp = new LinkedList<Producer>();
		for (int i = 0; i < PRODUCER_COUNT; i++) {
			Producer p = new Producer(bq);
			p.setName("PRODUCER"+i);
			lp.add(p);
		}
		
		
		LinkedList<Consumer> lc = new LinkedList<Consumer>();
		for (int i = 0; i < CONSUER_COUNT; i++) {
			Consumer c = new Consumer(bq);
			c.setName("CONSUMER"+i);
			lc.add(c);
		}
		
		
		System.out.println("start producer " +lp.size());
		Iterator<Producer> it = lp.iterator();
		while (it.hasNext()) {
			es.execute(it.next());
		}
		System.out.println("start consumer " +lc.size()) ;
		Iterator<Consumer> ic = lc.iterator();
		while (ic.hasNext()) {
			es.execute(ic.next());
		}
		
		try {
			Thread.sleep(20*1000);
			it = lp.iterator();
			while (it.hasNext()) {
				it.next().setFlag(false);
			}			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ic = lc.iterator();
		while (ic.hasNext()) {
			ic.next().setFlag(false);
		}
		
		es.shutdown();
	}
	
}
