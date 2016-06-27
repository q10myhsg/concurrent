package fc.heima;

public class TradatoinalSynchronized {

	public static void main(String[] args) {
		final Outputer o =new Outputer();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					o.printData("zangwenyang");
				}

			}

		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true)
					o.printData("yangjinping");
			}

		}).start();

	}

}

class Outputer {
	public  void printData(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}
}