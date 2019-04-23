package main.java.com.sparrow.zg.sort;

public class Squareroot {
	public static void main(String[] args) {

	}

	public static double squareroot(double n, int k) {
		int x = 1;
		for (int i = 0; i < k; i++) {
			double y = find(x, n);
		}

	}

	private static double find(double x, double n) {
		//0~n/2+1 上二分
		double mid = (n / 2 + 1) / 2;
		// 计算每个数对应的整数位
		//

		while (mid > 1) {
			double max = Math.pow(mid, 2d) + x;
			double min = Math.pow(mid, 2d) - x;

			if (max > n && min < n) {
				return mid;
			} else if (max > n) {
				mid = mid / 2;
			} else {
				mid = mid / 2 + mid;
			}
		}
		return 0;
	}
}
