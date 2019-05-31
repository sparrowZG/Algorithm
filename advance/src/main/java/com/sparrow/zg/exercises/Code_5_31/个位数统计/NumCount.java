package main.java.com.sparrow.zg.exercises.Code_5_31.个位数统计;

/**
 * 给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1,
 * dk-1>0)，请编写程序统计每种不同的个位数字出现的次数。
 * <p>
 * 例如：给定N = 100311，则有2个0，3个1，和1个3。
 * <p>
 * 输入描述: 每个输入包含1个测试用例，即一个不超过1000位的正整数N。
 * <p>
 * 输出描述: 对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按* D的升序输出。
 * <p>
 * 示例1
 * 输入：
 *    100311
 * 输出：
 * 0:2
 * 1:3
 * 3:1
 */
public class NumCount {
	public static void main(String[] args) {
		numCount(100311);
	}

	public static void numCount(int n) {
		String nStr = String.valueOf(n);
		char[] ch = nStr.toCharArray();
		int[] res = new int[10];
		for (char c : ch) {
			res[c - '0']++;
		}
		for (int i = 0; i < 10; i++) {
			if (res[i]!=0) {
				System.out.println(i+":"+res[i]);
			}
		}
	}
}
