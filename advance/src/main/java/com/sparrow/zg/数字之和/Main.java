package main.java.com.sparrow.zg.数字之和;

import java.util.Scanner;

/**
 * 对于给定的正整数 n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和。
 * 输入:
 *    每行输入数据包括一个正整数n(0<n<40000)
 * 输出描述
 *   对于每个输入数据，计算其各位数字之和，以及其平方值的数字之和，
 *   输出在一行中，之间用一个空格分隔，但行末不要有空格。
 */
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int value = in.nextInt();
			int valueSquare = (int)Math.pow(value,2);
			int res = 0;
			int resS = 0;
			while(value != 0){
				res += value%10;
				value = value/10;
			}
			while(valueSquare != 0){
				resS +=valueSquare%10;
				valueSquare = valueSquare/10;
			}
			System.out.print(res+" "+resS);
			System.out.println();
		}
	}
}
