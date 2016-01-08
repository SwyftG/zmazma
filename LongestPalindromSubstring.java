package oatwo;

import testforfun.PalindromicSubstring;

public class LongestPalindromSubstring {
	/*
	 * Soluion is to get the longest palindrome substring of string s.
	 * Return the longest palindrome string.
	 * Use two pointers to recored the start poinsition and end position of LPS.
	 * Iterate through string s and get the longest palindrom string.
	 * Time complexity is O(n^2), space complexity is O(1).
	 * 
	 *  @Param {String} s - input string.
	 */
	public static String Solution(String s) {
		// base case.
		if (s == null ||  s.length() == 0) return s;
		
		int start = 0;
		int end = 0;
		
		// Iterate through string and calculate value of start and end.
		for (int i = 0; i < s.length(); i++) {
			int len1 = getLen(s, i, i);
			int len2 = getLen(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	/*
	 * getLen is to get the length of parlindrom string which the middle element is left and right
	 * Return the length of palidrome string.
	 * 
	 * @Param {String} s - input string
	 * @Param {int} left - left position
	 * @Param {int} right - right position
	 */
	public static int getLen(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
	
	public static void main(String[] args) {
		PalindromicSubstring p = new PalindromicSubstring();
		System.out.println(Solution("abcdcbb"));
		System.out.println(p.solution2("aaaab"));
	}
	
	
}
