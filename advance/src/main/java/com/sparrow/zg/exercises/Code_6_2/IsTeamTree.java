package main.java.com.sparrow.zg.exercises.Code_6_2;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class IsTeamTree {
	public static void main(String[] args) {

	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s==null){
			return false;
		}
		if(s.val==t.val&&isSameTree(s,t)){
			return true;
		}
		return isSubtree(s.left,t)||isSubtree(s.right,t);
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p != null && q != null && q.val == p.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}
}
