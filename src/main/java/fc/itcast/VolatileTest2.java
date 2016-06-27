package fc.itcast;

public class VolatileTest2 {


	public static void main(String[] args){
		VolatileRunnable vr=null;
		ResourceImp2<Integer> r = new ResourceImp2<Integer>();
		for (int i  = 0;i<5;i++){
			vr = new VolatileRunnable(i+"",r);
			new Thread(vr).start();
		}
		
		try {
			Thread.sleep(1*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vr.setFlag(false);
		
	}
}
