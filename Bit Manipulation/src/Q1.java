
public class Q1 {
	public static void main(String[] args) {
		Integer n = 1024;
		Integer m = 19;
		System.out.println(merge(n, m, 2, 6));
	}
	
	static Integer merge(Integer n, Integer m, int i, int j) {
		while (j >= i) {
			if (getBit(m, j-i))
				n = setBit(n, j);
			else
				n = clearBit(n, j);
			j--;
		}
		return n;
	}
	
	static Integer setBit(Integer n, int i) {
		return (n | (1 << i));
	}
	
	static Integer clearBit(Integer n, int i) {
		return n & ~(1 << i);
	}
	
	static boolean getBit(Integer n, int i) {
		return (n & (1 << i)) != 0;
	}
}
