package main.java.com.sparrow.zg.剑指Offer.n个数中出现次数大于数组一半的数;

import java.util.HashMap;
import java.util.Scanner;


public class GreaterThanArr {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<String, Integer> hashMap = new HashMap<>();
		int count = 0;
		while (in.hasNext()) {
			String next = in.next();
			Integer value = hashMap.get(next);
			if (value != null) {
				hashMap.put(next, value + 1);
			} else {
				hashMap.put(next, 0);
			}
			count++;
		}
		int res = count / 2;
		for (String key : hashMap.keySet()) {
			Integer val = hashMap.get(key);
			if (val >= res) {
				System.out.println(key);
			}
		}
	}
}
