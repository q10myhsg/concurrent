package fc.itcast;

public class VolatileTest {

	public static boolean flag=true;
	public static void main(String[] args){
		for (int i  = 0;i<5;i++){
			new Thread(new Runnable(){
				
				@Override
				public void run() {
					while (flag){
						System.out.println(Thread.currentThread().getName()+" is running");	
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					System.out.println(Thread.currentThread().getName()+" is shutdown");
				}
				
			}).start();
		}
		try {
			Thread.sleep(3*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag=false;
		
	}
}
