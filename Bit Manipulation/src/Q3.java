
public class Q3 {
	public static void main(String args[]) {
		int a = 240294031;
		int nextSmallestSameBits = nextSmallest(a);
		int nextLargestSameBits = nextLargest(a);
		System.out.println("Current: " + a);
		System.out.println("Next largest: " + nextLargestSameBits);
		System.out.println("Next smallest: " + nextSmallestSameBits);
	}
	
	static int nextSmallest(int a) {
		int i;
		for (i = 0; !(!getBit(a, i) && getBit(a, i+1)); i++);
			a = setBit(a, i);
			a = clearBit(a, i+1);
		return a;
	}
	
	static int nextLargest(int a) {
		int i;
		for (i = 0; !(getBit(a, i) && !getBit(a, i+1)); i++);
			a = clearBit(a, i);
			a = setBit(a, i+1);
		return a;
	}
	
	static boolean getBit(int a, int i) {
		return (a & (1 << i)) != 0;
	}
	
	static int setBit(int a, int i) {
		return (a | (1 << i));
	}
	
	static int clearBit(int a, int i) {
		return (a & ~(1 << i));
	}
}
