package test.fc.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exchanger<String> exchanger = new Exchanger<String>();

		ExchangerRunnable<String> exchangerRunnable1 = new ExchangerRunnable<String>(exchanger, "A");

		ExchangerRunnable<String> exchangerRunnable2 = new ExchangerRunnable<String>(exchanger, "B");

		new Thread(exchangerRunnable1).start();
		new Thread(exchangerRunnable2).start();
	}

}
class ExchangerRunnable<E> implements Runnable{  
	  
    Exchanger<E> exchanger = null;  
    E    object    = null;  
  
    public ExchangerRunnable(Exchanger<E> exchanger, E object) {  
        this.exchanger = exchanger;  
        this.object = object;  
    }  
  
    public void run() {  
        try {  
            Object previous = this.object;  
  
            this.object = this.exchanger.exchange(this.object);  
  
            System.out.println(  
                    Thread.currentThread().getName() +  
                    " exchanged " + previous + " for " + this.object  
            );  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
}  