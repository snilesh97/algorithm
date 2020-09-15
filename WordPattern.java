// LeetCode problem Number 290 Word Pattern
// https://leetcode.com/problems/word-pattern/
// 15 September LeetCode Coding challenge


import java.util.*;

class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] arr = str.split(" ");

		if (arr.length != pattern.length())
			return false;

		HashMap<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				String value = map.get(c);
				if (!value.equals(arr[i])) {
					return false;
				}
			} else if (map.containsValue(arr[i])) {
				return false;
			}
			map.put(c, arr[i]);
		}

		return true;
	}

	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
		System.out.println(wp.wordPattern("abba", "dog dog dog dog"));
	}
}
