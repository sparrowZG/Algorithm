package main.java.com.sparrow.zg.tree.traversingBinaryTree;

import javax.naming.InsufficientResourcesException;

/**
 * 二叉树的遍历:
 * 先序遍历:
 * <p>
 * 中序遍历:
 * <p>
 * 后序遍历:
 */
class Node {
	public  Node left;
	public Node right;
	public Integer value;

	public Node() {
	}
	public Node(Integer value){
		this.value = value;
	}

	public Node(Integer value, Node left, Node right) {
		this.left = left;
		this.right = right;
		this.value = value;
	}
}

public class DLR_Tree {
	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);
		printFirstBinary(head);

	}

	//递归: 先序遍历
	public static void printFirstBinary(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value+"->");
		printFirstBinary(head.left);//右子树
		printFirstBinary(head.right);
	}
	//非递归: 先序遍历
	public static void printFirstBinary2(Node head){

	}
	//递归: 中序遍历
	public static void InorderBinary(Node head) {
		if (head == null) {
			return;
		}
		printFirstBinary(head.left);//右子树
		System.out.print(head.value+"->");
		printFirstBinary(head.right);
	}
	//递归: 后序遍历
	public static void postorderBinary(Node head) {
		if (head == null) {
			return;
		}
		printFirstBinary(head.left);//右子树
		printFirstBinary(head.right);
		System.out.print(head.value+"->");
	}


}
