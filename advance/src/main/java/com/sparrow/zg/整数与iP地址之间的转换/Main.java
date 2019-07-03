package main.java.com.sparrow.zg.整数与iP地址之间的转换;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String ip = in.next();
		int ipShi = in.nextInt();
		String[] ipArr = ip.split("\\.");
		int[] shi = new int[4];
		int res = 0;
		for (int i = 0; i < 4; i++) {
			res += Integer.valueOf(ipArr[i]) * ((int) Math.pow(256, 3 - i));
		}
		for (int i = 0; i < 4; i++) {
			shi[i] = ipShi % 256;
			ipShi = ipShi / 256;
		}
		System.out.println(res);
		System.out.println(shi[3] + "." + shi[2] + "." + shi[1] + "." + shi[0]);
	}
}
