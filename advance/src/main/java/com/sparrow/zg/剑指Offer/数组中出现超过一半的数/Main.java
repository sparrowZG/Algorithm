package main.java.com.sparrow.zg.剑指Offer.数组中出现超过一半的数;

/**
 * 数组中出现次数超过一半的数
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由
 * 于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 *
 * 题解:
 * 使用cnt记录一个数字重复的次数,当遍历到的数与ret相同时,就让cnt++,否则cnt--
 * 当cnt == 0 时,此时遍历到前i个数字, 说明当前ret不是最多的数,或者可能是最多的数
 * 当时此时我们可以将ret = array[i] 说明重复次数最多的数在i到n之间
 */
public class Main {
	public int MoreThanHalfNum_Solution(int[] array) {
		int ret = array[0];
		for (int i = 1, cnt = 1; i < array.length; i++) {
			cnt = ret == array[i] ? cnt + 1 : cnt - 1;
			if (cnt == 0) {
				ret = array[i];
				cnt = 1;
			}
		}
		int cnt = 0;
		for (int val : array) {
			if (val == ret) {
				cnt++;
			}
		}
		return cnt > array.length / 2 ? ret : 0;
	}
}
