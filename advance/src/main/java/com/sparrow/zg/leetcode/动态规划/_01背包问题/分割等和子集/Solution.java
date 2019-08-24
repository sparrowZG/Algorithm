package main.java.com.sparrow.zg.leetcode.动态规划._01背包问题.分割等和子集;

public class Solution {
	public boolean canPartition(int[] nums) {
		//非空判断
		if (nums.length < 2) {
			return false;
		}
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i];
		}
		if (count % 2 != 0) {
			return false;
		}
		int mid = count >> 1;
		return knapsack(mid, nums);
	}

	public boolean knapsack(int W, int[] nums) {
		boolean[] dp = new boolean[W + 1];
		for (int i = 0; i < nums.length; i++) {
			for (int j = W; j >= nums[i]; j--) {
				if (i == 0) dp[j] = (nums[i] == j);
				else dp[j] = dp[j] || dp[j - nums[i]];
			}
		}
		return dp[W];
	}
}
