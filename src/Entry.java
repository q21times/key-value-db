import java.util.Objects;

public class Entry {
	private final String key;
	private Object value;
	private Entry next;

	public Entry( String key, Object value, Entry next ) {
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public String getKey( ) {
		return key;
	}

	public Object getValue( ) {
		return value;
	}

	public Entry getNext( ) {
		return next;
	}

	public void setValue( Object value ) {
		this.value = value;
	}

	public void setNext( Entry next ) {
		this.next = next;
	}

	@Override
	public boolean equals( Object o ) {
		if (o instanceof Entry) {
			Entry entry = (Entry) o;
			return entry.key.equals(key) && entry.value.equals(value);
		} else {
		 	return false;
		}
	}

	@Override
	public int hashCode( ) {
		return Objects.hash(key, value);
	}
}