package test.fc.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
/**
PriorityBlockingQueue 是一个无界的并发队列。它使用了和类 java.util.PriorityQueue 一样的排序规则。你无法向这个队列中插入 null 值。
所有插入到 PriorityBlockingQueue 的元素必须实现 java.lang.Comparable 接口。因此该队列中元素的排序就取决于你自己的 Comparable 实现。
注意PriorityBlockingQueue中元素虽然没有代码级别验证comparable接口，但是后期会进行强制转换，运行时错误。所以必须继承Comparable
注意 PriorityBlockingQueue 对于具有相等优先级(compare() == 0)的元素并不强制任何特定行为。
同时注意，如果你从一个 PriorityBlockingQueue 获得一个 Iterator 的话，该 Iterator 并不能保证它对元素的遍历是以优先级为序的。
 * 
 * */
public class PriorityBlockingQueueExample {
	public static void main(String[] args) {
		BlockingQueue<PriorityEntity> queue   = new PriorityBlockingQueue<PriorityEntity>();  
		
		PriorityEntity p1 = new PriorityEntity(5,1);
		PriorityEntity p2 = new PriorityEntity(2,2);
		PriorityEntity p3 = new PriorityEntity(3,3);
		PriorityEntity p4 = new PriorityEntity(4,4);
		PriorityEntity p5 = new PriorityEntity(1,5);
		queue.add(p1);
		queue.add(p2);
		queue.add(p3);
		queue.add(p4);
		queue.add(p5);
		try {
			System.out.println(queue.take().toString());
			System.out.println(queue.take().toString());
			System.out.println(queue.take().toString());
			System.out.println(queue.take().toString());
			System.out.println(queue.take().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
//class PriorityEntity {
	class PriorityEntity implements Comparable<PriorityEntity> {  
    private static int count=0;  
    private int id=count++;  
    private int priority;  
    private int index=0;  
  
    public PriorityEntity(int _priority,int _index) {  
        this.priority = _priority;  
        this.index=_index;  
    }  
      
    public String toString(){  
        return id+"# [index="+index+" priority="+priority+"]";  
    }  
  
    //数字小，优先级高  
    public int compareTo(PriorityEntity o) {  
        return this.priority > o.priority ? 1  
                : this.priority < o.priority ? -1 : 0;  
    }  
  
    //数字大，优先级高  
//  public int compareTo(PriorityTask o) {  
//      return this.priority < o.priority ? 1  
//              : this.priority > o.priority ? -1 : 0;  
//  }  
}  