import java.util.List;
import java.util.Set;

public class MyHashMap  implements MyMap {

	private final int INITIAL_CAPACITY = 16;

	private Entry[] entries = new Entry[INITIAL_CAPACITY];

	private int size = 0;

	@Override
	public void put( String key, Object value ) {
		int pos = getElemPos(key, entries.length);
		Entry existing = entries[pos];
		if( existing == null ) {
			Entry entry = new Entry(key, value, null);
			entries[pos] = entry;
			size++;
		}else {
			while(true) {
				if (existing.getKey().equals(key)) {
					existing.setValue(value);
					return;
				}
				if(existing.getNext() == null) {
					existing.setNext(new Entry(key,    value, null));
					size++;
					return;
				}
				existing = existing.getNext();
			}

		}
	}

	@Override
	public Entry get( int key ) {
		return null;
	}

	@Override
	public Set<Integer> keySet( ) {
		return Set.of();
	}

	@Override
	public List<Entry> values( ) {
		return List.of();
	}

	@Override
	public boolean remove( int key ) {
		return false;
	}

	@Override
	public int size( ) {
		return size;
	}

	@Override
	public void clear( ) {

	}

	private int getElemPos(String key, int arrLength ) {
		return Math.abs(key.hashCode() % arrLength);
	}
}
