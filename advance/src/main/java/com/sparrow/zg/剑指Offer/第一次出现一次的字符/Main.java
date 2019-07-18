package main.java.com.sparrow.zg.剑指Offer.第一次出现一次的字符;

public class Main {
	public static void main(String[] args) {
		String str = "google";
		int val = FirstNotRepeatingChar(str);
		System.out.println(val);
	}

	public static int FirstNotRepeatingChar(String str) {
		int[] arr = new int[64];
		//a 97 A 65
		char[] strChar = str.toCharArray();
		for (int i = 0; i < strChar.length; i++) {
			if (strChar[i] < 97) {
				arr[(int) (strChar[i] - 65)]++;
			} else {
				arr[(int) (strChar[i] - 97 + 26)]++;
			}
		}
		for (int i = 0; i < strChar.length; i++) {
			if (strChar[i] < 97) {
				if (arr[(int) (strChar[i] - 65)] == 1) {
					return i;
				}
			} else {
				if (arr[(int) (strChar[i] - 97 + 26)] == 1) {
					return i;
				}
			}
		}
		return -1;
	}
}
