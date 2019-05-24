package main.java.com.sparrow.zg.计算糖果;

import java.util.Scanner;

/**
 * 计算糖果
 *
 */
public class Sweets {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] arr = new int[4];
		for(int i = 0;i<4;i++){
			arr[i] = in.nextInt();
		}
		int[] res = new int[3];
		boolean flag = getRes(arr,res);
		if(flag){
			System.out.print(res[0]+" "+res[1]+" "+res[2]);
		}else{
			System.out.print("No");
		}
	}
	public static boolean getRes(int[] arr,int[] res){
		res[0] = (arr[0]+arr[2])/2;
		res[1] = (arr[1]+arr[3])/2;
		res[2] = (res[1]-arr[1]);
		if((res[0]-res[1])!=arr[0]){
			return false;
		}else if((res[1]-res[2])!=arr[1]){
			return false;
		}else if((res[0]+res[1])!= arr[2]){
			return false;
		}else if((res[1] +res[2])!= arr[3]){
			return false;
		}
		return true;

	}
}
