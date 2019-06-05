package main.java.com.sparrow.zg.洗牌问题;

import java.util.Scanner;

public class Shuffle {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = Integer.valueOf(in.next());
		for(int i = 0;i < T; i++){
			int n = Integer.valueOf(in.next());
			System.out.println("n  ->  "+n);
			int k = Integer.valueOf(in.next());
			int[] arr = new int[n * 2];//接受输入的数据
			for(int j = 0;j < n*2; j++){
				arr[j] = Integer.valueOf(in.next());
			}
			printArray(arr);
			System.out.println();
			//写一个方法打印输出洗牌k次后的从上往下的序列
			printK(n,k,arr);
		}
	}
	//3 3 1 1 2 3 4 5 6 3 2 1 2 3 4 5 6 2 2 1 1 1 1
	public static void printK(int n, int k, int[] arr){
		int[] temp = new int[arr.length];
		for(int i = 0; i < k; i++){
			int index = 0;
			for(int j = 0;j < n/2; j++){
				temp[index++] = arr[j];
				temp[index++] = arr[j+n/2];
			}
			for(int x = 0; x < n; x++){
				arr[x] = temp[x];
			}
		}
		for(int y = 0; y < 2*n; y++){
			if(y == n-1){
				System.out.print(arr[y]);
			}else{
				System.out.print(arr[y]+" ");
			}
		}
		System.out.println();
	}
	public static void printArray(int[] arr){
		for(int i = 0;i<arr.length;i++){
			System.out.print(arr[i]+"");
		}
		System.out.println();
	}


}
