package com.sparrow.zg.chapter_01;

public class Hanoi{
	public static void main(String[] args) {
		int n = 3;
		printHanoi(n);
	}

	private static void printHanoi(int n) {
		if(n<1){
			return;
		}
		printHanoi(n,"左","中","右");
	}

	private static void printHanoi(int n, String form, String mid, String to) {
		if(n<1){
			return;
		}
		printHanoi(n-1,form,to,mid);
		System.out.println("将"+n+"从"+form+"移到"+to);
		printHanoi(n-1,mid,form,to);
	}
}
