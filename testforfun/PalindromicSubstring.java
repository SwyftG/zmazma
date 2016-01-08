package testforfun;

public class PalindromicSubstring {
	public String longestPali(String s) {
		if (s == null || s.length() == 0) return s;
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = getLength(s, i, i);
			int len2 = getLength(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				end = i + len / 2;
				start = i - (len - 1) / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	public int getLength(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
	
	
	public static String solution2(String s) {
		String T = preProcess(s);
        int n = T.length();
        int[] p = new int[n];
        int center = 0, right = 0;
        for (int i = 1; i < n - 1; i++) {
            int j = 2 * center - i;  //j and i are symmetric around center
            p[i] = (right > i) ? Math.min(right - i, p[j]) : 0;
            // Expand palindrome centered at i
            while (T.charAt(i + 1 + p[i]) == T.charAt(i - 1 - p[i]))
                p[i]++;
            
            // If palindrome centered at i expand past right,
            // then adjust center based on expand palindrome
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        
        //  Find the longest palindrome
        int maxLength = 0, centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLength) {
                maxLength = p[i];
                centerIndex = i;
            }
        }
        
        centerIndex = (centerIndex - 1 - maxLength) / 2;
        return s.substring(centerIndex, centerIndex + maxLength);
    }
    
    // preProcess the original string s.
    // For example, s = "abcdefg", then the rvalue = "^#a#b#c#d#e#f#g#$"
    private static String preProcess(String s) {
        if (s == null || s.length() == 0)  return "^$";
        StringBuilder rvalue = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++)
            rvalue.append("#").append(s.substring(i, i+1));
        rvalue.append("#$");
        return rvalue.toString();
    }

	
	
	public static void main(String[] args) {
		PalindromicSubstring p = new PalindromicSubstring();
		System.out.println(p.longestPali("aaaab"));
		System.out.println(p.solution2("aaaab"));
	}
}
