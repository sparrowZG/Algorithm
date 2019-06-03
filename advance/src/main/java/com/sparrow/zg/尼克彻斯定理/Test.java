package main.java.com.sparrow.zg.尼克彻斯定理;

public class Test {
	public static void main(String[] args) {
		int m = 3;
		int n = m * m - m + 1;
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < m - 1; i++) {
			result.append(n + "+");
			n = n + 2;
		}
		result.append(n);
		System.out.print(result);
	}
}
