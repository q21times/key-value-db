import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

	@Test
	void shouldPutAndGetValue() {
		MyHashMap map = new MyHashMap();

		map.put("name", "Daniil");

		Entry entry = map.get("name");

		assertNotNull(entry);
		assertEquals("Daniil", entry.getValue());
	}

	@Test
	void shouldReturnNullForMissingKey() {
		MyHashMap map = new MyHashMap();

		assertNull(map.get("unknown"));
	}

	@Test
	void shouldUpdateExistingValue() {
		MyHashMap map = new MyHashMap();

		map.put("name", "Ivan");
		map.put("name", "Daniil");

		assertEquals(1, map.size());
		assertEquals("Daniil", map.get("name").getValue());
	}

	@Test
	void shouldRemoveExistingKey() {
		MyHashMap map = new MyHashMap();

		map.put("name", "Daniil");

		boolean removed = map.remove("name");

		assertTrue(removed);
		assertEquals(0, map.size());
		assertNull(map.get("name"));
	}

	@Test
	void shouldReturnFalseWhenRemovingMissingKey() {
		MyHashMap map = new MyHashMap();

		assertFalse(map.remove("unknown"));
	}

	@Test
	void shouldContainKey() {
		MyHashMap map = new MyHashMap();

		map.put("name", "Daniil");

		assertTrue(map.containsKey("name"));
		assertFalse(map.containsKey("age"));
	}

	@Test
	void shouldReturnAllKeys() {
		MyHashMap map = new MyHashMap();

		map.put("name", "Daniil");
		map.put("city", "Berlin");

		Set<String> keys = map.keySet();

		assertEquals(2, keys.size());
		assertTrue(keys.contains("name"));
		assertTrue(keys.contains("city"));
	}

	@Test
	void shouldClearMap() {
		MyHashMap map = new MyHashMap();

		map.put("name", "Daniil");
		map.put("city", "Berlin");

		map.clear();

		assertEquals(0, map.size());
		assertTrue(map.keySet().isEmpty());
	}

	@Test
	void shouldIncreaseSize() {
		MyHashMap map = new MyHashMap();

		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);

		assertEquals(3, map.size());
	}

	@Test
	void shouldHandleCollisions() {
		MyHashMap map = new MyHashMap();

		map.put("FB", "first");
		map.put("Ea", "second");

		assertEquals("first", map.get("FB").getValue());
		assertEquals("second", map.get("Ea").getValue());
	}

	@Test
	void shouldRemoveElementFromCollisionChain() {
		MyHashMap map = new MyHashMap();

		map.put("FB", "first");
		map.put("Ea", "second");

		assertTrue(map.remove("FB"));

		assertNull(map.get("FB"));
		assertEquals("second", map.get("Ea").getValue());
	}

	@Test
	void shouldResizeAndKeepAllValues() {
		MyHashMap map = new MyHashMap();

		for (int i = 0; i < 100; i++) {
			map.put("key" + i, "value" + i);
		}

		assertEquals(100, map.size());

		for (int i = 0; i < 100; i++) {
			assertEquals(
					"value" + i,
					map.get("key" + i).getValue()
			);
		}
	}
}