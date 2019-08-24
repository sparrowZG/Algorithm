package main.java.com.sparrow.zg.leetcode.动态规划._01背包问题.经典背包;

public class Knapsack {
	public static void main(String[] args) {

	}

	/**
	 * @param weight 重量
	 * @param n      物品个数
	 * @param w      最大重量
	 * @return
	 */
	public int knappsack(int[] weight, int n, int w) {
		boolean[][] dp = new boolean[n][w + 1];
		dp[0][0] = true;
		if (weight[0] <= w) {
			dp[0][weight[0]] = true;
		}
		for (int i = 1; i < n; ++i) { //动态转移方程
			for (int j = 0; j <= w; ++j) {
				if (dp[i - 1][j] == true) {
					dp[i][j] = dp[i - 1][j];
				}
			}
			for (int j = 0; j <= w; ++j) {
				if (dp[i - 1][j] == true) {
					dp[i][j + weight[i]] = true;
				}
			}
		}
		for (int i = w; i >= 0; --i) {
			if (dp[n - 1][i] = true) {
				return i;
			}
		}
		return 0;
	}


	public int knapsack2(int W, int N, int[] weights, int[] values) {
		int[] dp = new int[W + 1];
		for (int i = 1; i <= N; i++) {
			int w = weights[i];
			int v = values[i];
			for (int j = W; j >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j - w] + v);
			}
		}
		return dp[W];
	}
}
