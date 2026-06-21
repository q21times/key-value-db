import collections.MyHashMap;
import entity.StorageEngine;

public class Main {

	public static void main(String[] args) throws Exception {

		MyHashMap map = new MyHashMap();

		StorageEngine storage =
				new StorageEngine("database.txt");

		storage.load(map);

		map.put("name", "Daniil");
		map.put("city", "Ufa");

		storage.save(map);
	}
}
