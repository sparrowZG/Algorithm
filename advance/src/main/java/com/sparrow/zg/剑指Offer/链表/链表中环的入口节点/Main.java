package main.java.com.sparrow.zg.剑指Offer.链表.链表中环的入口节点;

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

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		ListNode f = pHead;
		ListNode s = pHead;
		do {
			f = f.next.next;
			s = s.next;
		} while (f != s);
		f = pHead;
		while(f!=s){
			s = s.next;
			f = f.next;
		}
		return f;
	}
}
