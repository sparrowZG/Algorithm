package main.java.com.sparrow.zg.组个最小数;

import java.util.Scanner;

public class litterNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		for (int i = 0; i < 10; i++) {
			num[i] = sc.nextInt();
		}
		for (int i = 1; i < 10; i++) {
			if (num[i] != 0) {
				System.out.print(i);
				num[i]--;
				break;
			}
		}
		for (int i = 0; i < num[0]; i++) {
			System.out.print(0);
		}
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < num[i]; j++) {
				System.out.print(i);
			}
		}
		System.out.println();
	}

}
