package oatwo;

import java.util.Stack;


public class ParenthesesCount {
	/*
	 * Solution is to count the valid parentheses in string.
	 * Return number of pair of parentheses.
	 * Use stack data structure to recored steps in each iteration.
	 * Time complexity is O(n), space complexity is O(n).
	 * 
	 * @Param {String} s - input string, only contains '(' or ')'.
	 */
	public static int Solution(String s) {
		// Base case.
		if (s == null || s.length() == 0) return 0;
		
		// Initialize stack and iterator through string.
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else {
				if (!stack.isEmpty() && isValidPair(stack.peek(), c)) {
					stack.pop();
				} else {
					return -1;
				}
			}
		}
		return stack.isEmpty() ? s.length() / 2 : -1;
	}
	
	/*
	 * isValidPair to check two chars are pair parentheses or not.
	 */
	public static boolean isValidPair(char a, char b) {
		return a == '(' && b == ')';
	}
	
}
