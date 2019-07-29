package main.java.com.sparrow.zg.剑指Offer.字符流中第一个不重复的字符;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 *
 *分析: 首先想到的是 : 1. 在插入的时候调整好
 *                  2.  或者在取的时候在做调整
 *
 *     1. 插入的时候调整
 *         1.使用一个数组利用数组下标存储对应的字符
 *         2.使用一个Queue存字符
 *         3.当队列不空时检查,对应数组中字符个数>2,则删除,此时队列中的元素就只剩下第一个不重复的字符
 *
 */
public class Main {
	private int[] arr = new int[256];
	private Queue<Character> queue = new LinkedList<>();
	public void Insert(char ch){
		arr[ch]++;
		queue.add(ch);
		while (!queue.isEmpty()&&arr[queue.peek()]>1){
			queue.poll();
		}
	}
	public char FirstAppearingOnce(){
		return queue.isEmpty() ? '#': queue.peek();
	}

}
