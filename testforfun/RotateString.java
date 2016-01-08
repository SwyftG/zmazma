package testforfun;

public class RotateString {
	public static boolean Solution(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) return false;
		String s = s1 + s1;
		System.out.println(s.indexOf(s2));
		return s.indexOf(s2) != -1 ? true : false;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Solution("abcd", "csab"));
	}
}
