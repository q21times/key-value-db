import java.util.List;
import java.util.Set;

public interface MyMap {

	void put( String key, Object value );

	Entry get( String key);

	Set<String> keySet();

	List<Entry> values();

	boolean remove(String key);

}
