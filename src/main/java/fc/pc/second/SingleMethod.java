package fc.pc.second;

public class SingleMethod {

	private static SingleMethod s;

	private SingleMethod() {

	}

	public static synchronized SingleMethod getInstance() {
		if (s == null)
			s = new SingleMethod();
		return s;
	}

	public static SingleMethod getInstance1() {
		if (s == null)
			synchronized (SingleMethod.class) {
				if (s == null) {
					s = new SingleMethod();
				}
			}
		return s;
	}

	public static void main(String[] args) {

	}

}
