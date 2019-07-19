package main.java.com.sparrow.zg.剑指Offer.链表.删除链表中重复节点;

/**
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 */
class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;

	}
}
public class Main {
	public ListNode deleteDuplication(ListNode pHead){
		//删除重复节点
		if(pHead == null || pHead.next  == null){
			return pHead;
		}
		ListNode next = pHead.next;
		if(pHead.val != next.val){
			pHead.next = deleteDuplication(next);
			return pHead;
		}else{
			if(next != null && pHead.val == next.val){
				next = next.next;
			}
			return deleteDuplication(next);
		}
	}
}
