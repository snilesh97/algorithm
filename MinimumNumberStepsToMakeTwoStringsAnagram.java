// LeetCode problem Number 1347 https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
// 1347. Minimum Number of Steps to Make Two Strings Anagram

class MinimumNumberStepsToMakeTwoStringsAnagram {

	public int minSteps(String s, String t) {

		int[] chars = new int[26];

		for (int i = 0; i < s.length(); i++) {

			chars[s.charAt(i) - 'a']++;
			chars[t.charAt(i) - 'a']--;
		}

		int sum = 0;

		for (int i = 0; i < chars.length; i++) {

			if (chars[i] > 0)
				sum = sum + chars[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		MinimumNumberStepsToMakeTwoStringsAnagram minimumNumberStepsToMakeTwoStringsAnagram = new MinimumNumberStepsToMakeTwoStringsAnagram();
		System.out.println(minimumNumberStepsToMakeTwoStringsAnagram.minSteps("leetcode", "practice")); // 5
	}
}
