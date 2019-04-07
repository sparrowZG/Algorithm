package com.sparrow.zg.chapter_01;

/*

马拉车算法:Manacher:求字符串中的最长回文子串的长度,
 */
public class Manacher {
	public static void main(String[] args) {
		String str = "abc1234321ab";
		System.out.println(maxLcpsLength(str));
	}

	private static int maxLcpsLength(String str) {
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];//回文半径数组
		int R = -1;//回文右边界
		int C = -1;//回文中心
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			pArr[i] = i > R ? 1 : Math.min(pArr[2 * C - i], R - i);
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
					pArr[i]++;
				}else {
					break;
				}
			}
			if (i + pArr[i] > R) {
				R = i + pArr[i] - 1;
				C = i;
			}
			max = Math.max(max, pArr[i]);
		}
		return max - 1;
	}

	private static char[] manacherString(String str) {
		char[] chr = str.toCharArray();
		char[] chars = new char[chr.length * 2 + 1];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = i % 2 == 0 ? '#' : chr[i / 2];
		}
		return chars;
	}
}
