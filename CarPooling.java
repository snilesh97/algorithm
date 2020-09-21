// LeetCode problem Number 1094. Car Pooling
// https://leetcode.com/problems/car-pooling/
// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3467/

class CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {
		int[] arr = new int[1001];
		int max = 0;

		for (int i = 0; i < trips.length; i++) {
			arr[trips[i][1]] += trips[i][0]; // Checking the number of people will be in the car at a time.
			arr[trips[i][2]] += -trips[i][0];
			max = Math.max(max, trips[i][2]);
		}

		if (arr[0] > capacity)
			return false;

		for (int i = 1; i <= max; i++) {
			arr[i] += arr[i - 1];
			if (arr[i] > capacity)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
		System.out.print((new CarPooling()).carPooling(trips, 4));
	}
}