package fc.itcast;

import java.util.LinkedList;
import java.util.List;

public class ResourceImp2<T> implements ResourceFlag<T> {

	List<T> list = new LinkedList<T>();
	boolean flag = true;
	// boolean flag = true;

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

	@Override
	public boolean getFlag() {
		// synchronized (list){
		return flag;
		// }

	}

	@Override
	public void setFlag(boolean flag) {
		// synchronized (list){
		this.flag = flag;
		// }
	}
}
