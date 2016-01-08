package testforfun;

public class CountOne {
	public static int Solution(byte x) {
		int count = 0;
		while (x != 0) {
			byte tmp = (byte) (x & 1);
			if (tmp == 1){
				count++;
			}
			x = (byte) (x >> 1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		byte m = (byte) 01010;
		byte n = (byte) 1;
		System.out.println((int)m);
		System.out.println(Solution(m));
	}
}
 