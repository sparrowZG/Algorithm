package main.java.com.sparrow.zg.剑指Offer.另一棵树的子树;

/**
 * 判断一棵树是否是另一棵树的子树
 * 给定两个头节点
 */
class Node {
	Node left;
	Node right;
	int val;
	public Node(){}
	public Node(int val){
		this.val = val;
	}
}

public class Main {
	public static void main(String[] args) {
		Node head1 = new Node(5);
		head1.right = new Node(6);
		head1.left = new Node(4);
		head1.right.left = new Node(3);
		head1.right.right = new Node(2);


		Node head2 = new Node(5);
		head2.right = new Node(6);
		head2.left = new Node(4);
		head2.right.left = new Node(3);
		head2.right.right = new Node(1);

		boolean flag = isSameTree(head1,head2);
		System.out.println(flag);

	}

	/**
	 * 判断两颗树是否完全相同
	 * 给定两个头节点
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static boolean isSameTree(Node head1, Node head2) {
		if (head1 == null && head2 == null) {
			return true;
		}
		if (head1 == null || head2 == null) {
			return false;
		}
		if (head1.val != head2.val) {
			return false;
		}
		return isSameTree(head1.left,head2.left)&&isSameTree(head1.right,head2.right);
	}


}
