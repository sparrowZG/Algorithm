package main.java.com.sparrow.zg.二叉树.traversingBinaryTree;

import java.util.Stack;

/**
 * 二叉树的遍历:
 * 先序遍历:
 * <p>
 * 中序遍历:
 * <p>
 * 后序遍历:
 */
class Node {
	public Node left;
	public Node right;
	public Integer value;

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Node() {
	}

	public Node(Integer value) {
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
		System.out.println();
		printFirstBinary2(head);
		System.out.println();
		System.out.println("中序遍历");
		InorderBinary(head);
		System.out.println();
		InorderBinary2(head);
		System.out.println();
		System.out.println("后序遍历");
		postorderBinary(head);
		System.out.println();
		postorderBinary2(head);

	}

	//递归: 先序遍历
	public static void printFirstBinary(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + "->");
		printFirstBinary(head.left);//右子树
		printFirstBinary(head.right);
	}

	//非递归: 先序遍历
	//使用栈压入,
	public static void printFirstBinary2(Node head) {
		if (head == null) {
			return;
		}
		Node root = head;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.value + "->");
			if (root.right != null) {
				stack.push(root.right);
			}
			if (root.left != null) {
				stack.push(root.left);
			}
		}

	}

	//递归: 中序遍历
	public static void InorderBinary(Node head) {
		if (head == null) {
			return;
		}
		InorderBinary(head.left);//右子树
		System.out.print(head.value + "->");
		InorderBinary(head.right);
	}

	//非递归: 中序遍历
	public static void InorderBinary2(Node head) {
		if (head == null) {
			return;
		}
		Node root = head;
		Stack<Node> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				System.out.print(root.value + "->");
				root = root.right;
			}
		}
	}

	//递归: 后序遍历
	public static void postorderBinary(Node head) {
		if (head == null) {
			return;
		}
		postorderBinary(head.left);//右子树
		postorderBinary(head.right);
		System.out.print(head.value + "->");
	}

	//非递归: 后序遍历
	//在stack1中加入头节点,在将头节点加入stack2 中,
	//先判断当前左子树有没有节点,加入stack1 中后,在判断当前头节点的右子树有没有节点
	//当前的堆栈中没有空继续操作
	//将刚才加入的右子树节点当作头节点,加入到stack2中
	//将左子树加入stack2中,stack2中的顺序就成了 中 - 右 - 左
	//打印就是我们需要的后序遍历
	public static void postorderBinary2(Node head) {
		if (head == null) {
			return;
		}
		Node root = head;
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			root = stack1.pop();
			stack2.push(root);
			if (root.left != null) {
				stack1.push(root.left);
			}
			if (root.right != null) {
				stack1.push(root.right);
			}
		}
		while (!stack2.isEmpty()) {
			root = stack2.pop();
			System.out.print(root.value + "->");
		}
	}

}
