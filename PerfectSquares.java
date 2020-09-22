// LeetCode problem Number 279. Perfect Squares
// https://leetcode.com/problems/perfect-squares/

class PerfectSquares {
	public int numSquares(int n) {
		while (n % 4 == 0) // legrandes 3's square theorem
			n /= 4;
		if (n % 8 == 7)
			return 4;
		for (int x = 0; x * x <= n; x++) {
			int y = (int) Math.sqrt(n - x * x);
			if (x * x + y * y == n) {
				if (x == 0 || y == 0)
					return 1;
				else
					return 2;
			}
		}
		return 3;
	}
	
	public static void main(String[] args) {
		PerfectSquares perfectSquares = new PerfectSquares();
		System.out.print(perfectSquares.numSquares(10));
	}
}