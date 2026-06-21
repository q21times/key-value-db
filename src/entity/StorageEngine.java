package entity;

import collections.MyHashMap;

import java.io.*;

public class StorageEngine {

	private final String filename;
	public StorageEngine( String filename ) {
		this.filename = filename;
	}

	public void save( MyHashMap map ) throws IOException {

		try (BufferedWriter wr = new BufferedWriter(new FileWriter(filename))) {
			for(Entry entry : map.values()){
				wr.write(entry.getKey() + "=" + entry.getValue());
			}

			wr.newLine();
		}
	}

	public void load( MyHashMap map ) throws IOException {
		File file = new File(filename);

		if(!file.exists()){
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;

			while ((line = reader.readLine()) != null){
				String[] parts = line.split("=", 2);
				String key = parts[0];
				String value = parts[1];

				map.put(key, value);
			}
		}


	}


}
