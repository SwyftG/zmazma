package testforfun;

public class GreyCode {
	public static int Solution(byte term1, byte term2) {
		byte x = (byte)(term1^term2);
		int count = 0;
		while (x != 0) {
			x = (byte) (x & (x - 1));
			count++;
		}
		return count == 1 ? 1:0;
	}
	
	
	public static int Solution2(byte term1, byte term2) {
		byte x = (byte)(term1^term2);
		int count = 0;
		for (int i = 0; i <= 7; i++) {
			byte tmp = (byte)(1<<i);
			if (tmp == x) {
				return 1;
			}
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Solution2((byte)110,(byte)101)); 
	}
}
