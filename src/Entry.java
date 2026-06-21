public class Entry {
	private int key;
	private Object value;
	public Entry( int key, Object value) {
		this.key = key;
		this.value = value;
	}
	public int getKey() {
		return key;
	}
	public Object getValue() {
		return value;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}
