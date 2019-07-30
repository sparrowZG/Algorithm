package main.java.com.sparrow.zg.二叉树;



/**
 * 判断是否是平衡二叉树
 * : 使用递归判断左右子树高度
 * 比较两个的高度,不超过1,则为平衡二叉树
 */
public class JudjeBalanceTree {
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
		System.out.println(isBalanceTree(head));
	}

	public static boolean isBalanceTree(Node head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		System.out.println(getHeight(head, 0, res));
		return res[0];
	}

	private static int getHeight(Node head, int level, boolean[] res) {
		if(head==null){
			return level;
		}
		int lH = getHeight(head.left,level+1,res);
		if(!res[0]){
			return level;
		}
		int rH = getHeight(head.right,level+1,res);
		if(!res[0]){
			return level;
		}
		if(Math.max(lH,rH)>1){
			res[0] =false;
		}
		return Math.max(rH,lH);
	}
}
