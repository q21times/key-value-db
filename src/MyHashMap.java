import java.util.List;
import java.util.Set;

public class MyHashMap  implements MyMap {

	private final int INITIAL_CAPACITY = 16;

	private Entry[] entries = new Entry[INITIAL_CAPACITY];

	private int size = 0;

	@Override
	public void put( int key, Object value ) {

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

	private int getElemPos(int key, int arrLenght ) {
		return Math.abs(key) % arrLenght;
	}
}
