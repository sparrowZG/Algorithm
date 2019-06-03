package main.java.com.sparrow.zg.两个超长的整数相加;


import java.util.Arrays;
import java.util.HashMap;

public class BigNumAdd {
	public static void main(String[] args) {

		AddLongInteger("1","9999999999999999999999999999");
	}

	public static void  AddLongInteger(String addend,String augend){
		int len=0;
		char[] a1 = addend.toCharArray();
		char[] a2 = augend.toCharArray();
		if(a1.length > a2.length){
			len = a1.length + 1;
		}else{
			len = a2.length + 1;
		}

		char[] temp = new char[len];
		char[] result;

		char[] b1 = new char[a1.length];
		char[] b2 = new char[a2.length];

		for(int i = 0;i < a1.length;i++){
			b1[a1.length - 1 - i] = a1[i];
		}

		for(int i = 0;i < a2.length;i++){
			b2[a2.length - 1 - i] = a2[i];
		}

		for(int i = 0; i < temp.length; i++){
			temp[i] = '0';
		}

		for(int i = 0; i < len-1;i++){
			int res = 0;
			if(b1.length -1 - i >=0 && b2.length -1 - i >= 0){
				res = b1[i] - '0' + b2[i] - '0';
			}else if(b1.length -1 - i >= 0 && b2.length -1 - i < 0){
				res = b1[i] - '0';
			}else if(b1.length -1 - i < 0 && b2.length -1 - i >= 0){
				res = b2[i] - '0';
			}

			int value = temp[i]-'0'+res;
			temp[i] = (char) (value%10 + '0') ;
			temp[i+1] += value/10;
		}
		while(temp[len - 1] == '0'){
			len--;
		}
		result = new char[len];
		int s = result.length;

		for(int i = 0;i < s; i++){
			result[s-1-i] = temp[i];
		}
		for (char c:result
			 ) {
			System.out.print(c);
		}
	}
}
