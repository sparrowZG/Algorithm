package main.java.com.sparrow.zg.使用栈实现队列;

import java.util.Stack;

public class StackToQueue {

	public class Solution {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void push(int node) {
			if (stack2.isEmpty()) {
				stack1.push(node);
			}
		}

		public int pop() {
			int res = 0;
			if (!stack1.isEmpty() && stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
				res = stack2.pop();
			}
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return res;
		}
	}
}
