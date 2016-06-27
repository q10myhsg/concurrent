package fc.itcast;

public class RemoveRun extends ItcastRunnable {

	RemoveRun(String name, Resource<Integer> r) {
		super(name, r);

	}
	@Override
	public void run() {
		while (flag) {
			resource.remove();
			System.out.println(name+" remove one");
		}
	}
}
