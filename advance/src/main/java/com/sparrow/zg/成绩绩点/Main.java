package main.java.com.sparrow.zg.成绩绩点;

import java.util.Scanner;

public class Main {
	public static void printArr(double[] arr){
		for(double e : arr){
			System.out.print(e+" ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = Integer.valueOf(in.next());
		int[] g = new int[num];
		int[] c = new int[num];
		double[] gpa = new double[num];
		for(int i = 0; i < num; i++){
			g[i] = Integer.valueOf(in.next());
		}
		for(int i = 0; i < num; i++){
			c[i] = Integer.valueOf(in.next());
		}
		for(int i= 0;i<num;i++){
			if(c[i]<60){
				gpa[i] = 0;
				continue;
			}else if(c[i]<64){
				gpa[i] = 1;
				continue;
			}else if(c[i]<68){
				gpa[i] = 1.5;
				continue;
			}else if(c[i]<72){
				gpa[i] = 2.0;
				continue;
			}else if(c[i]<75){
				gpa[i] = 2.3;
				continue;
			}else if(c[i]<78){
				gpa[i] = 2.7;
				continue;
			}else if(c[i]<82){
				gpa[i] = 3.0;
				continue;
			}else if(c[i]<85){
				gpa[i] = 3.3;
				continue;
			}else if(c[i]<90){
				gpa[i] = 3.7;
				continue;
			}else if(c[i]<=100){
				gpa[i] = 4.0;
				continue;
			}else {
				System.out.print("num is non");
			}
		}
		printArr(gpa);
		for(int i = 0; i < num; i++){
			gpa[i] = gpa[i] * g[i];
		}
		double x = 0;
		double y = 0;
		for(int i = 0; i < num; i++){
			x += gpa[i];
			y += g[i];
		}
		double res = x/y;
		System.out.printf("%.2f",res);
	}
}
