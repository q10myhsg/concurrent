package fc.pc;

public class Seller implements Runnable {
	String name;
	public Seller(String name){
		this.name=name;
	}
	
	@Override
	public void run() {

	}
	public void print(){
		System.out.println("seller "+name);
	}

}
