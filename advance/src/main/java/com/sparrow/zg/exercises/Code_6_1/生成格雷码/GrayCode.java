package main.java.com.sparrow.zg.exercises.Code_6_1.生成格雷码;

/**
 * 生成格雷码
 * 题目描述
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，
 * 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
 * <p>
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 * <p>
 * 测试样例：
 * 1
 * 返回：["0","1"]
 */
public class GrayCode {
	public static String[] grayCode(int n) {
		if (n == 1) {
			return new String[]{"0", "1"};
		} else {
			String[] temp = grayCode(n - 1);
			String[] res = new String[temp.length * 2];
			int i = 0;
			for (i = 0; i < temp.length; i++) {
				res[i] = "0" + temp[i];
			}
			//开始倒叙
			for (int j = temp.length - 1; j >= 0; j--, i++) {
				res[i] = "1"+temp[j];
			}
			return res;
		}
	}
	public static void main(String[] args) {
		String[] res = grayCode(3);
		for (String r:res
			 ) {
			System.out.println(r);
		}
	}
}
