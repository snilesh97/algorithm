// LeetCode problem Number 980. Unique Paths III
// https://leetcode.com/problems/unique-paths-iii/
// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3466/

class UniquePathsIII {
	int totalPath = 0;

	public int uniquePathsIII(int[][] grid) {
		int totalZero = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0)
					totalZero++;
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					dfs(grid, i, j, totalZero);
			}
		}
		return totalPath;

	}

	public void dfs(int[][] grid, int i, int j, int totalZero) {

		if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == -1
				|| (grid[i][j] == 2 && totalZero != 0) || grid[i][j] == 99)
			return;

		if (grid[i][j] == 2 && totalZero == 0)
			totalPath++;
		if (grid[i][j] == 0)
			totalZero--;

		int temp = grid[i][j];
		grid[i][j] = 99;
		dfs(grid, i + 1, j, totalZero);
		dfs(grid, i - 1, j, totalZero);
		dfs(grid, i, j + 1, totalZero);
		dfs(grid, i, j - 1, totalZero);
		grid[i][j] = temp;
	}
	
	public static void main(String[] args) {
		UniquePathsIII uniquePathsIII = new UniquePathsIII();
		int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
		System.out.println(uniquePathsIII.uniquePathsIII(grid));
	}

}