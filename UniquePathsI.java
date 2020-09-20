// LeetCode problem Number 62. Unique Paths
// https://leetcode.com/problems/unique-paths/submissions/

import java.util.*;

class UniquePathsI {
	int totalPath = 0;

	/* By BackTracking Time limit exceed for large test case */
	public int uniquePathsByBackTracking(int m, int n) {
		int[][] grid = new int[m][n];
		dfs(grid, 0, 0);
		return totalPath;
	}

	public void dfs(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 99)
			return;

		if (i == grid.length - 1 && j == grid[0].length - 1)
			totalPath++;

		int temp = grid[i][j];
		grid[i][j] = 99;
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);
		grid[i][j] = temp;
	}

	/* By Dyanamic Programming */
	public int uniquePathsByDyanamicProgramming(int m, int n) {
		int[][] dp = new int[m][n];

		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {

			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
			dp[i][0] = 1;
		}

		return dp[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		UniquePathsI uniquePathsI = new UniquePathsI();
		System.out.println(uniquePathsI.uniquePathsByDyanamicProgramming(3, 7));
		System.out.println(uniquePathsI.uniquePathsByBackTracking(3, 7));
	}
}
