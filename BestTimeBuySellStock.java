// LeetCode problem Number 121 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// 18 September LeetCode Coding challenge

class BestTimeBuySellStock {
	public int maxProfit(int[] prices) {

		if (prices.length == 0) {
			return 0;
		}
		int max = prices[0];
		int min = prices[0];
		int maxi = 0;

		for (int i = 1; i < prices.length; i++) {

			if (min > prices[i]) {
				maxi = Math.max(maxi, max - min);
				min = prices[i];
				max = prices[i];
			} else if (max < prices[i]) {
				max = prices[i];
				maxi = Math.max(maxi, max - min);
			}
		}

		if (maxi < 0) {
			return 0;
		}
		return maxi;
	}

	public static void main(String[] args) {
		BestTimeBuySellStock bestTimeBuySellStock = new BestTimeBuySellStock();
		int[] prices = { 3, 2, 6, 5, 0, 3 };
		System.out.println(bestTimeBuySellStock.maxProfit(prices)); // 4
	}
}
