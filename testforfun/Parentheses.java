package testforfun;

import java.util.Stack;

public class Parentheses {
	/*
	 * validParentheses is to check whether the input String str conatins balanced sequence of parenthese or not.
	 * return the count number of balanced parentheses.
	 * Iterator through the string and use a stack to recored open parentheses
	 * 
	 * for loop's complexity is O(n), isValid function's complexity is O(1), hence, 
	 * time complexity is O(n)
	 * @Param str is input string, only contains '(' or ')'
	 */
	public int validParentheses(String str) {
		if (str == null || str.length() == 0) return -1;
		Stack<Character> stack = new Stack<Character>();
		for (char c : str.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else {
				if (!stack.isEmpty() && isValid(stack.peek(), c)) {
					stack.pop();
				} else {
					return -1;
				}
			}
		}
		return stack.isEmpty() ? str.length() / 2 : -1;
	}
	
	public boolean isValid(char a, char b) {
		return a == '(' && b == ')';
	}
	// time complexity
	
	public static void main(String[] args) {
		Parentheses p = new Parentheses();
		System.out.println(p.validParentheses("()())"));
	}
	
}
