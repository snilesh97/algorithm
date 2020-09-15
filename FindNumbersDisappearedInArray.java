// LeetCode problem Number 448. Find All Numbers Disappeared in an Array
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.*;

class FindNumbersDisappearedInArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> list = new ArrayList<Integer>();

		int currentNumber = 0;
		for (int i = 0; i < nums.length; i++) {
			currentNumber = Math.abs(nums[i]);
			if (nums[currentNumber - 1] > 0) {
				nums[currentNumber - 1] *= -1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				list.add(i + 1);
			}
		}

		return list;

	}

	public static void main(String[] args) {
		FindNumbersDisappearedInArray findNumbersDisappearedInArray = new FindNumbersDisappearedInArray();
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findNumbersDisappearedInArray.findDisappearedNumbers(nums));
	}
}
