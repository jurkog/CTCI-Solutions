
public class Q5 {
	public static void main(String[] args) {
		System.out.println("Conversions of (31, 14): " + conversions(31, 14));
		System.out.println("Conversions of (27, 12): " + conversions(27, 12));
		System.out.println("Conversions of (31, 19): " + conversions(31, 19));
	}
	
	static int conversions(int i, int j) {
		return countSetBits(i ^ j);
	}
	
	static int countSetBits(int i) {
		int setBits = 0;
		for (int j = i; j > 0; j >>= 1)
			setBits += j & 1;
		return setBits;
	}
	
}
