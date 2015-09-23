
public class Q6 {
	public static void main(String[] args) {
		int number = 92902902;
		int swapped = swap(number);
		System.out.println("Number: " + Integer.toBinaryString(number).substring(Integer.toBinaryString(number).length() - 8, Integer.toBinaryString(number).length()));
		System.out.println("Swapped: " + Integer.toBinaryString(swapped));
	}
	
	static int swap(int number) {
		int oddBitsShifted= (0xaa & number) >> 1;
		int evenBitsShifted = (0x55 & number) << 1;
		return (oddBitsShifted | evenBitsShifted);
	}
}

