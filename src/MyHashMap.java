import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyHashMap  implements MyMap {

	private final int INITIAL_CAPACITY = 16;
	private final double LOAD_FACTOR = 0.75;


	private Entry[] entries = new Entry[INITIAL_CAPACITY];

	private int size = 0;

	@Override
	public void put( String key, Object value ) {
		if(size >= (entries.length * LOAD_FACTOR)) {
			increaseCapacity();
		}
		boolean put =  put( key, value, entries );
		if( put ) {
			size++;
		}
	}

	@Override
	public Entry get( String key ) {
		int pos = getElemPos(key, entries.length);
		Entry exist = entries[pos];
		while (exist != null) {
			if( exist.getKey().equals(key)) {
				return exist;
			}
			exist = exist.getNext();
		}
		return null;
	}

	@Override
	public Set<String> keySet( ) {
		Set<String> result = new HashSet<String>();
		for (Entry entry : entries) {
			Entry existing = entry;
			while (existing != null) {
				result.add(existing.getKey());
				existing = existing.getNext();
			}
		}
		return result;
 	}

	@Override
	public List<Entry> values( ) {
		List<Entry> result = new ArrayList<>();
		for (Entry entry : entries) {
			Entry existing = entry;
			while (existing != null) {
				result.add(existing);
				existing = existing.getNext();
			}
		}
		return result;
	}

	@Override
	public boolean remove( String key ) {
		int pos = getElemPos(key, entries.length);
		Entry exist = entries[pos];
		if( exist != null && exist.getKey().equals(key)) {
			entries[pos] = exist.getNext();
			size--;
			return true;
		}else {
			while(exist != null ) {
				Entry nextElem = exist.getNext();
				if( nextElem == null) {
					return false;
				}
				if(nextElem.getKey().equals(key)) {
					exist.setNext(nextElem.getNext());
					size--;
					return true;
				}
				exist = exist.getNext();
			}
		}
		return false;
	}

	@Override
	public void clear() {
		entries = new Entry[INITIAL_CAPACITY];
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}
	private void increaseCapacity( ) {
		Entry[] newEntries = new Entry[entries.length * 2];
		for (Entry entry : entries) {
			Entry existing = entry;
			while (existing != null) {
				put(existing.getKey(), existing.getValue(), newEntries);
				existing = existing.getNext();
			}
		}
		entries = newEntries;
	}
	private int getElemPos(String key, int arrLength ) {
		return (key.hashCode() & 0x7fffffff) % arrLength;
	}

	private boolean put(String key, Object value, Entry[] dst) {
		int pos = getElemPos(key, dst.length);
		Entry existing = dst[pos];
		if( existing == null ) {
			Entry entry = new Entry(key, value, null);
			dst[pos] = entry;
			return true;
		}else {
			while(true) {
				if (existing.getKey().equals(key)) {
					existing.setValue(value);
					return false;
				}
				if(existing.getNext() == null) {
					existing.setNext(new Entry(key,    value, null));
					return true;
				}
				existing = existing.getNext();
			}

		}
	}

	public boolean containsKey(String key) {
		return get(key) != null;
	}
}
