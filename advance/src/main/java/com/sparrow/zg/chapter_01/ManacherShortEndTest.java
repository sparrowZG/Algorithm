package main.java.com.sparrow.zg.chapter_01;

public class ManacherShortEndTest {
	//使用manacher 来求拼成 回文字符串

	public static void main(String[] args) {
		String str = "ab12321";
		String res = joint(str);
		System.out.println(res);
	}

	private static String joint(String str) {
		int maxCount = manacherString(str);
		char[] sour = str.toCharArray();
		char[] res = new char[2 * str.toCharArray().length - maxCount];
		int p = sour.length - maxCount-1;
		for (int i = 0; i < res.length; i++) {
			if (i < sour.length) {
				res[i] = sour[i];
			}else{
				res[i]= sour[p];
				p--;
			}
		}
		return String.valueOf(res);
	}

	/**
	 * @param str
	 * @return 返回需要拼接的数组的开始位置
	 */
	private static int manacherString(String str) {
		char[] arr = manacherToChars(str);
		int[] pArr = new int[arr.length];//回文半径数组
		int R = -1;
		int C = -1;
		int maxCount = 0;
		for (int i = 0; i < arr.length; i++) {
			pArr[i] = i > R ? 1 : Math.min(pArr[2 * C - i], R - i);
			while (i - pArr[i] > -1 && i + pArr[i] < arr.length) {
				if (arr[i - pArr[i]] == arr[i + pArr[i]]) {
					pArr[i]++;
				} else {
					break;
				}
			}
			//更新R 和C
			if (i + pArr[i] > R) {
				R = i + pArr[i] - 1;
				C = i;
			}
			if (R == arr.length - 1) {
				maxCount = pArr[i] - 1;
				break;
			}
		}
		return maxCount;
	}

	private static char[] manacherToChars(String str) {
		char[] arrs = str.toCharArray();
		char[] res = new char[arrs.length * 2 + 1];
		for (int i = 0; i < res.length; i++) {
			res[i] = i % 2 == 0 ? '#' : arrs[i / 2];
		}
		return res;
	}
}
