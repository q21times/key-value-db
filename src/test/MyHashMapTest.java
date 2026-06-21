package test;

import collections.MyHashMap;
import entity.Entry;
import org.junit.jupiter.api.Assertions;
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
		Assertions.assertEquals("Daniil", entry.getValue());
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

		Assertions.assertEquals(1, map.size());
		Assertions.assertEquals("Daniil", map.get("name").getValue());
	}

	@Test
	void shouldRemoveExistingKey() {
		MyHashMap map = new MyHashMap();

		map.put("name", "Daniil");

		boolean removed = map.remove("name");

		assertTrue(removed);
		Assertions.assertEquals(0, map.size());
		assertNull(map.get("name"));
	}

	@Test
	void shouldReturnFalseWhenRemovingMissingKey() {
		MyHashMap map = new MyHashMap();

		Assertions.assertFalse(map.remove("unknown"));
	}

	@Test
	void shouldContainKey() {
		MyHashMap map = new MyHashMap();

		map.put("name", "Daniil");

		Assertions.assertTrue(map.containsKey("name"));
		Assertions.assertFalse(map.containsKey("age"));
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

		Assertions.assertEquals(0, map.size());
		Assertions.assertTrue(map.keySet().isEmpty());
	}

	@Test
	void shouldIncreaseSize() {
		MyHashMap map = new MyHashMap();

		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);

		Assertions.assertEquals(3, map.size());
	}

	@Test
	void shouldHandleCollisions() {
		MyHashMap map = new MyHashMap();

		map.put("FB", "first");
		map.put("Ea", "second");

		Assertions.assertEquals("first", map.get("FB").getValue());
		Assertions.assertEquals("second", map.get("Ea").getValue());
	}

	@Test
	void shouldRemoveElementFromCollisionChain() {
		MyHashMap map = new MyHashMap();

		map.put("FB", "first");
		map.put("Ea", "second");

		Assertions.assertTrue(map.remove("FB"));

		assertNull(map.get("FB"));
		Assertions.assertEquals("second", map.get("Ea").getValue());
	}

	@Test
	void shouldResizeAndKeepAllValues() {
		MyHashMap map = new MyHashMap();

		for (int i = 0; i < 100; i++) {
			map.put("key" + i, "value" + i);
		}

		Assertions.assertEquals(100, map.size());

		for (int i = 0; i < 100; i++) {
			Assertions.assertEquals(
					"value" + i,
					map.get("key" + i).getValue()
			);
		}
	}
}