package fc.itcast;

import java.util.LinkedList;
import java.util.List;

public class ResourceImp<T> implements Resource<T> {

	List<T> list = new LinkedList<T>();

	@Override
	public boolean add(T t) {
		synchronized (list) {
			list.add(t);
			return true;
		}

	}

	@Override
	public boolean remove() {
		if (list.size() > 0) {
			synchronized (list) {
				list.remove(0);
			}
			return true;
		}
		return false;
	}
}
