package main.java.com.sparrow.zg.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

class MyLRULinkedHashMap extends LinkedHashMap {
	private static final int MAX_CAPACITY = 4;

	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size() > MAX_CAPACITY;
	}
	public MyLRULinkedHashMap(){
		super(MAX_CAPACITY,0.75f,true);
	}
}

public class MyLRU {
	public static void main(String[] args) {
		MyLRULinkedHashMap lru = new MyLRULinkedHashMap();
		lru.put("z",16);
		lru.put("z",18);
		lru.put("c",15);
		System.out.println(lru);
	}
}
