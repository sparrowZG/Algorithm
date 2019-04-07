package com.sparrow.zg.chapter_01;


public class GatMax {
	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;
		int b = Integer.MIN_VALUE;
		System.out.println(printMax1(a, b));
		System.out.println(printMax2(a, b));
	}

	private static int printMax1(int a, int b) {
		int c = a - b;//
		int abX = getHigh(c);//0
		int abY = rev(abX);//1

		return a * abX + b * abY;
	}

	private static int printMax2(int a, int b) {
		int c = a - b;//
		int aN = getHigh(a);
		int bN = getHigh(b);
		int cN = getHigh(c);

		int difSab = aN ^ bN; //两数相同为0,不同为1
		int sameSab = rev(difSab); //取反
		int returnA = difSab * aN + sameSab * cN; //两数符号相同的时候,取决于c
		int returnB = rev(returnA);//取反

		return a * returnA + b * returnB;
	}

	private static int getHigh(int n) {
		return rev((n >> 31) & 1);
	}

	private static int rev(int n) {
		return n ^ 1;
	}

}
