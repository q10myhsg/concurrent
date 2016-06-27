package test.fc.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*
 * DelayQueue 对元素进行持有直到一个特定的延迟到期。
 * DelayQueue 将会在每个元素的 getDelay() 方法返回的值的时间段之后才释放掉该元素。
 * 如果返回的是 0 或者负值，延迟将被认为过期，该元素将会在 DelayQueue 的下一次 take  被调用的时候被释放掉。
 * */
public class DelayQueueExample {

	public static void main(String[] args) {
        Random rand=new Random(47);  
        
        
        DelayQueue<DelayedTask> queue=new DelayQueue<DelayedTask>();  
        ExecutorService exec=Executors.newCachedThreadPool();  
        for(int i=0;i<20;i++){  
            queue.put(new DelayedTask(rand.nextInt(5000)));  
        }  
        //增加EndSentinel的目的是为了提示执行结束，5000大于随机出来的所有delay time
        queue.add(new DelayedTask.EndSentinel(5000, exec));  
        //启动consumer
        exec.execute(new DelayedTaskConsumer(queue));  
	}

}

class DelayedTask implements Delayed, Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final int delta;
	private final long trigger;
	protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();

	public DelayedTask(int delayInMilliseconds) {
		delta = delayInMilliseconds;
		trigger = System.nanoTime()
				+ java.util.concurrent.TimeUnit.NANOSECONDS.convert(delta, java.util.concurrent.TimeUnit.MILLISECONDS);
		sequence.add(this);
	}

	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		DelayedTask that = (DelayedTask) o;
		if (this.trigger > that.trigger)
			return 1;
		if (this.trigger < that.trigger)
			return -1;
		return 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this + "  is running");
	}

	public String toString() {
		return "  Task:" + id + " delta:" + delta;
	}

	public String summary() {
		return " id:" + id + "  delta:" + delta;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(trigger - System.nanoTime(), java.util.concurrent.TimeUnit.NANOSECONDS);
	}

	public static class EndSentinel extends DelayedTask {
		private ExecutorService exec;

		public EndSentinel(int delayInMilliseconds, ExecutorService exec) {
			super(delayInMilliseconds);
			this.exec = exec;
		}

		public void run() {
			for (DelayedTask dt : sequence) {
				System.out.println(dt.summary() + "  ");
			}
			System.out.print(' ');
			System.out.println(this + " Calling ShutdownNow()");
			exec.shutdownNow();
		}
	}

}
class DelayedTaskConsumer implements Runnable{  
    private DelayQueue<DelayedTask> dq;  
    public DelayedTaskConsumer(DelayQueue<DelayedTask> q){  
        dq=q;  
    }  
    @Override  
    public void run(){  
        try {  
            while(!Thread.interrupted()){  
                dq.take().run();  
            }  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println("finished delayedtask consume!!!!!");  
    }  
} 