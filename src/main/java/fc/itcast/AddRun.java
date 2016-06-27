package fc.itcast;

public class AddRun extends ItcastRunnable {

	public AddRun(String name, Resource<Integer> r) {
		super(name, r);
	}

	@Override
	public void run() {
		while (flag) {
			resource.add(1);
			System.out.println(name+" add one");
		}
	}
}
