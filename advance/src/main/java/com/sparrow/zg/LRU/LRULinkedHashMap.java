package main.java.com.sparrow.zg.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap {
	private static final int MAX_ENTRIES = 3;

	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size() > MAX_ENTRIES;
	}

	LRUCache() {
		super(MAX_ENTRIES, 0.75f, true);
	}
}

public class LRULinkedHashMap {
	public static void main(String[] args) {
		LRUCache l = new LRUCache();
		l.put("zhang", 78);
		l.put("ge", 90);
		l.put("zhgneg", 8080);
		l.put("ge", 90);
		l.put("jiang", 78);
		l.put("jiang", 78);
		l.put("jiang", 78);
		l.put("jiang", 78);
		System.out.println(l);
	}
}
