package test.fc.concurrent;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

/**
 * concurrent包里面还提供了一个非常有用的锁，读写锁ReadWriteLock 

concurrent包里面还提供了一个非常有用的锁，读写锁ReadWriteLock  
下面是ReadWriteLock接口的说明：  
A ReadWriteLock maintains a pair of associated locks, 
one for read-only operations and one for writing. 
The read lock may be held simultaneously by multiple reader threads,
 so long as there are no writers. The write lock is exclusive.  

意思是说读锁可以有很多个锁同时上锁，只要当前没有写锁；  
写锁是排他的，上了写锁，其他线程既不能上读锁，也不能上写锁；同样，需要上写锁的前提是既没有读锁，也没有写锁；  
两个写锁不能同时获得无需说明，下面一段程序说明下上了读锁以后，其他线程需要上写锁也无法获得  
 * 
 * */
public class ReadWriteLock {
	@Test  
	public void testRWLock_getw_onr()  
	{  
	    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();  
	   
	    final Lock rlock = lock.readLock();  
	    final Lock wlock = lock.writeLock();  
	   
	    final CountDownLatch l  = new CountDownLatch(3);  
	   
	    // start r thread  
	    new Thread(new Runnable() {  
	   
	        @SuppressWarnings("static-access")
			@Override  
	        public void run() {  
	   
	        	System.out.println(new Date() + "thread 1 prepare to get rlock");
	            rlock.lock();  
	            System.out.println(new Date() + " thread 1 now to get rlock");  
	            
	            try {  
	                Thread.currentThread().sleep(15 * 1000);  
	            } catch (InterruptedException e) {  
	   
	                e.printStackTrace();  
	            }  
	   
	            System.out.println(new Date() + " thread 1  prepare to unlock rlock");  
	            rlock.unlock();  
	            System.out.println(new Date() + " thread 1 now to unlock rlock");
	            l.countDown();  
	        }  
	    }).start();  
	    
	    // start r thread  
	    new Thread(new Runnable() {  
	   
	        @SuppressWarnings("static-access")
			@Override  
	        public void run() {  
	   
	        	System.out.println(new Date() + " thread 2 prepare to get rlock");
	            rlock.lock();  
	            System.out.println(new Date() + " thread 2 now to get rlock");  
	            
	            try {  
	                Thread.currentThread().sleep(10 * 1000);  
	            } catch (InterruptedException e) {  
	   
	                e.printStackTrace();  
	            }  
	   
	            System.out.println(new Date() + " thread 2 prepare to unlock rlock");  
	            rlock.unlock();  
	            System.out.println(new Date() + " thread 2 now to unlock rlock");
	            l.countDown();  
	        }  
	    }).start();  
	   
	    // start w thread  
	    new Thread(new Runnable() {  
	   
	        @Override  
	        public void run() {  	   
	            
	        	System.out.println(new Date() + " thread 3 prepare to get wlock");
	            wlock.lock();  	   
	            System.out.println(new Date() + " thread 3 now to get wlock");  
	            System.out.println(new Date() + " thread 3 prepare to unlock wlock");  
	            wlock.unlock();
	            System.out.println(new Date() + " thread 3 now to unlock wlock");
	            l.countDown();  
	        }  
	    }).start();  
	   
	    
	    new Thread(new Runnable() {  
	 	   
	        @Override  
	        public void run() {  	  
	            
	        	System.out.println(new Date() + " thread 4 prepare to get wlock");
	            wlock.lock();  	   
	            System.out.println(new Date() + " thread 4 now to get wlock");  
	            System.out.println(new Date() + " thread 4 prepare to unlock wlock");  
	            wlock.unlock();
	            System.out.println(new Date() + " thread 4 now to unlock wlock");
	            l.countDown();  
	        }  
	    }).start();  	    
	    try {  
	        l.await();  
	    } catch (InterruptedException e) {  
	   
	        e.printStackTrace();  
	    }  	   
	    System.out.println(new Date() + "finished");  
	}
}
