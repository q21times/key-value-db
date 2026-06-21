import java.util.List;
import java.util.Set;

public interface MyMap {

	void put (int key, Object value);

	Entry get(int key);

	Set<Integer> keySet();

	List<Entry> values();

	boolean remove(int key);

	int size();

	void clear();
}
