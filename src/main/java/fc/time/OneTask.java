package fc.time;

import java.util.Timer;
import java.util.TimerTask;

public class OneTask extends TimerTask {
	private int id;

	public OneTask(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		 Timer timer = new Timer(); 
		 timer.schedule(new  OneTask(1), 5000);
		 
		 timer.schedule(new OneTask(2), 3000, 1000);
		 
	}

	@Override
	public void run() {
		System.out.println("id " + id + " is running");

	}

}
