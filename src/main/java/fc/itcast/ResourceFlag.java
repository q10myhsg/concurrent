package fc.itcast;

public interface ResourceFlag<T>extends Resource<T> {
	boolean getFlag();
	void setFlag(boolean flag);
}
