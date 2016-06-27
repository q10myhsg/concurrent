package fc.itcast;

import java.util.HashMap;

public class CacheSystem<T> {
	HashMap<String, T> hm = new HashMap<String, T>();

	public T get(String key) {
		T t = hm.get(key);
		if (t == null) {
			T tt = getData();
			hm.put(key, tt);
			t = this.get(key);
		}
		return t;
	}

	public T getData() {
		return null;
	}

	public static void main(String[] args) {

	}
}
