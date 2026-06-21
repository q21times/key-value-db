import collections.MyHashMap;
import entity.Entry;

public class KeyValueDB {

	private final MyHashMap storage = new MyHashMap();

	public void set(String key, Object value) {
		storage.put(key, value);
	}

	public Object get(String key) {
		Entry entry = storage.get(key);
		return  entry == null ? null : entry.getValue();
	}

	public boolean delete(String key) {
		storage.remove(key);
		return true;
	}
}
