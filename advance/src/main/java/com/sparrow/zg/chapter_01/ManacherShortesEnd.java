package main.java.com.sparrow.zg.chapter_01;

/**
 * 给定一个字符串,在后面添加字符,是整个字符串为回文字符串,求最少添加多少的字符?
 *
 * 解题思路:使用manacher,求出回文右边界,当回文右边界R第一次到达,字符串的尾部时,将此时的回文中心确定的,
 *         回文字符串去掉,然后将字符串开头部分翻转就是我们要求得最少添加的字符
 */

class ManacherShortestEnd {
	public static void main(String[] args) {
		String str = "abcbc";
		System.out.println(manacherShortestEnd(str));
	}

	public static String manacherShortestEnd(String str) {
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];
		int R = -1;
		int C = -1;
		int maxContain = -1;
		for (int i = 0; i < charArr.length; i++) {
			pArr[i] = i > R ? 1 : Math.min(pArr[C * 2 - i], R - i);
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
					pArr[i]++;
				} else {
					break;
				}
			}
			if (i + pArr[i] > R) {
				R = i + pArr[i] - 1;
				C = i;
			}
			if (R == charArr.length - 1) {
				maxContain = pArr[i];
				break;
			}
		}
		char[] res = new char[str.length() - maxContain + 1];
		for (int i = 0; i < res.length; i++) {
			res[res.length - 1 - i] = charArr[i * 2 + 1];
		}
		return String.valueOf(res);

	}

	/**
	 * @param str 源字符串
	 * @return #a#b#c#b#c#
	 */
	private static char[] manacherString(String str) {
		char[] sourceChar = str.toCharArray();
		char[] resultChar = new char[sourceChar.length * 2 + 1];
		for (int i = 0; i < resultChar.length; i++) {
			resultChar[i] = i % 2 == 0 ? '#' : sourceChar[i / 2];
		}
		System.out.println(resultChar);
		return resultChar;
	}
}
