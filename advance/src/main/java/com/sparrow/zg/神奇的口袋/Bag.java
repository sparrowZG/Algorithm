package main.java.com.sparrow.zg.神奇的口袋;

public class Bag {
	public static void main(String[] args) {
		int[] arr = {20, 20, 20};
		System.out.println(countMode(arr, 0, 0));

	}

	public static int countMode(int[] arr, int res, int i) {
		if (res == 40) {
			return 1;
		}
		if (i >= arr.length) {
			return 0;
		}
		return countMode(arr, res + arr[i], i + 1) + countMode(arr, res, i + 1);

	}
}
