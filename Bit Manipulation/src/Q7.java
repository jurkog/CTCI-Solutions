
public class Q7 {
	public static void main(String[] args) {
		int array[] = {0, 1, 2, 3, 4, 6, 7, 8};
		int expect = 0;
		for (int i = 0; i < array.length; i++, expect ^= 1) {
			if (expect != (array[i] & 1)) {
				System.out.println("Number missing: " + i);
				System.exit(0);
			}
		}
		
	}
}
