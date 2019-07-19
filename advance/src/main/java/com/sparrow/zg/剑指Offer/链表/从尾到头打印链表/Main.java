package main.java.com.sparrow.zg.剑指Offer.链表.从尾到头打印链表;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;

	}
}

public class Main {
	public static void main(String[] args) {

	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		//使用头插法反转链表
		ListNode head = new ListNode(-1);
		while (listNode != null) {
			ListNode temp = listNode.next;
			listNode.next = head.next;
			head.next = listNode;
			listNode = temp;
		}
		//生成数组
		ArrayList<Integer> arr = new ArrayList<>();
		ListNode p = head.next;
		while (p != null) {
			arr.add(p.val);
			p = p.next;
		}
		return arr;
	}
}
