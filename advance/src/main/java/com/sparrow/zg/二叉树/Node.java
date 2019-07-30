package main.java.com.sparrow.zg.二叉树;

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