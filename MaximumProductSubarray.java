// LeetCode problem Number 152 https://leetcode.com/problems/maximum-product-subarray/
// 11 September LeetCode Coding challenge

class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums.length == 0)
			return -1;

		int current_max = nums[0];
		int current_min = nums[0];
		int final_max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int temp = current_max;
			current_max = Math.max(Math.max(nums[i] * current_max, nums[i] * current_min), nums[i]);
			current_min = Math.min(Math.min(nums[i] * temp, nums[i] * current_min), nums[i]);

			if (current_max > final_max) {
				final_max = current_max;
			}
		}

		return final_max;
	}

	public static void main(String[] args) {
		MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
		int[] nums = { 2, 3, -2, 4 };
		System.out.println(maximumProductSubarray.maxProduct(nums));
	}
}
