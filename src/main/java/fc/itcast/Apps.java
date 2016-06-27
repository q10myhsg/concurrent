package fc.itcast;

public class Apps {
	public static void main(String[] args) {
		Resource<Integer> r = new ResourceImp<Integer>();
		
		new Thread(new AddRun("add-1",r)).start();
		new Thread(new AddRun("add-2",r)).start();
		new Thread(new RemoveRun("remove-1", r)).start();
		new Thread(new RemoveRun("remove-2", r)).start();	
	}
}

