// LeetCode problem Number 1299. Replace Elements with Greatest Element on Right Side
// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

import java.util.*;

class ReplaceElementsWithGreatestElementOnRightSide {
	public int[] replaceElements(int[] arr) {

		int lastElement = arr[arr.length - 1];
		arr[arr.length - 1] = -1;

		int currentElement = 0;
		for (int i = arr.length - 2; i >= 0; i--) {

			currentElement = arr[i];
			arr[i] = lastElement;

			if (lastElement < currentElement) {
				lastElement = currentElement;
			}
		}
		return arr;

	}

	public static void main(String[] args) {
		ReplaceElementsWithGreatestElementOnRightSide replaceElementsWithGreatestElementOnRightSide = new ReplaceElementsWithGreatestElementOnRightSide();
		int[] nums = { 17, 18, 5, 4, 6, 1 };
		nums = replaceElementsWithGreatestElementOnRightSide.replaceElements(nums);
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
