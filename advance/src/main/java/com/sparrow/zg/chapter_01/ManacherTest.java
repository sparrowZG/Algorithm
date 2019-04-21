package main.java.com.sparrow.zg.chapter_01;

public class ManacherTest {
	//思路整理: 求最长回文子串
	//  每个数都向两边扩,求出每个数对应的回文半径,然后在回文半径数组中找到最大的那个值,就是最长回文半径,从而求出最长回文子串

	/**
	 * manacher 算法就是通过记录
	 * 1.pArr[]回文半径数组来加速,查找每个回文半径的时间
	 * 2.R 最右回文右边界
	 * 3.C 最右回文右边界对应的回文中心
	 * 4.max 最大的回文子串
	 */
	public static void main(String[] args) {
		String str = "ad12321d";
		int a = manacherLength(str);
		System.out.println(a);
	}

	private static int manacherLength(String str) {
		char[] chars = manacherString(str);//字符串转字符数组,并添加特殊字符'#'
		int[] pArr = new int[chars.length];
		int R = -1;
		int C = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < chars.length; i++) {
			pArr[i] = i > R ? 1 : Math.min(pArr[2 * C - i], R - i);
			while (i - pArr[i] > -1 && i + pArr[i] < chars.length) {
				if (chars[i + pArr[i]] == chars[i - pArr[i]]) {
					pArr[i]++;
				} else {
					break;
				}
			}
			//更新R 和 C
			if(i+pArr[i]>R){
				R = i+pArr[i]-1;
				C = i;
			}
			max = Math.max(max,pArr[i]);
		}
		return max - 1;
	}

	private static char[] manacherString(String str) {
		char[] arr = str.toCharArray();
		char[] res = new char[arr.length * 2 + 1];
		for (int i = 0; i < res.length; i++) {
			res[i] = i % 2 == 0 ? '#' : arr[i / 2];
		}
		return res;
	}
}