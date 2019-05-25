package main.java.com.sparrow.zg.exercises.Code_5_25;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DLR_tree {
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
		System.out.println("按层遍历:");
		preLevel(head);
		System.out.println(isBanleanTree(head));
		boolean[] res = new boolean[1];
		res[0] = true;
		System.out.println(getHeight(head, 0, res));

	}

	//前序遍历
	public static void preorder(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node root = head;
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.println(root.getValue() + "->");
			if (root.right != null) {
				stack.push(root.right);
			}
			if (root.left != null) {
				stack.push(root.left);
			}
		}
	}

	//中序遍历
	public static void inorderBinary(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node root = head;
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				System.out.println(root.getValue() + "->");
				root = root.right;
			}
		}
	}
	//后序遍历
	public static void postorderBinary(Node head){
		if(head==null){
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		Node root = head;
		stack1.push(root);
		while(!stack1.isEmpty()){
			root = stack1.pop();
			stack2.push(root);
			//左 由 中
			if(root.left!=null){
				stack1.push(root.left);
			}
			if(root.right!=null){
				stack1.push(root.right);
			}
		}
		while (!stack2.isEmpty()){
			root = stack2.pop();
			System.out.print(root.getValue()+"->");
		}
	}
	//按层遍历:
	public static void preLevel(Node head){
		if(head == null){
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		Node root = head;
		queue.offer(root);
		while(!queue.isEmpty()){
			root = queue.poll();
			System.out.print(root.getValue()+"->");
			if(root.left!=null){
				queue.offer(root.left);
			}
			if(root.right!=null){
				queue.offer(root.right);
			}
		}
	}
	//判断一棵树是否是平衡二叉树
	public static boolean isBanleanTree(Node head){
		int level = 1;
		boolean[] res = new boolean[1];
		Node root = head;
		res[0] = true;
		getHeight(root,level,res);
		return res[0];
	}
	//计算树的高度
	private static int getHeight(Node root, int level, boolean[] res) {
		if(root==null){
			return level;
		}
		int lH = getHeight(root.left,level+1,res);
		if(!res[0]){
			return level;
		}
		int rH = getHeight(root.right,level+1,res);
		if(!res[0]){
			return level;
		}
		if(Math.abs(lH-rH)>1){
			res[0] = false;
		}
		return Math.max(lH,rH);
	}
}
