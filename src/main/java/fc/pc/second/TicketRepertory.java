package fc.pc.second;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketRepertory implements Storage {
	public static final int size = AppTest.storageSize;
	private List<Integer> ticketList = new LinkedList<Integer>();
	// 锁
	private final Lock lock = new ReentrantLock();
	// 仓库满的条件变量
	private final Condition full = lock.newCondition();
	// 仓库空的条件变量
	private final Condition empty = lock.newCondition();

	public boolean addTicket(int i) {
		boolean flag = false;
		lock.lock();

		if (ticketList.size() == size) {
			try {
				System.out.println("TicketRepertory is full fail to insert " + i);
				full.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			ticketList.add(i);
			flag=true;
			System.out.println(toString()  + " "+Thread.currentThread().getName()+ " add "+i);
		}		
		empty.signalAll();
		lock.unlock();
		return flag;
	}

	public int buyTicket() {
		int ret = -1;
		lock.lock();
		if (ticketList.size() == 0) {
			try {
				empty.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			ret = ticketList.remove(0);
			System.out.println(toString()  + " "+Thread.currentThread().getName()+ " remove "+ret);
			full.signalAll();
		}
		
		lock.unlock();
		return ret;
	}

	@Override
	public String toString() {
		return ticketList.toString();
	}

}
