
public class Q2 {
	public static void main(String[] args) {
		System.out.println(floatToBinary(0.0905f));
	}
	
	static String floatToBinary(float f) {
		StringBuffer ret = new StringBuffer("0.");
		int i = 0;
		while (f != 0.0 && i < 32) {
			f = 2 * f;
			int bit = (int)f;
			f-=bit;
			ret.append(bit);
			i++;
		}
		if (f != 0)
			return "ERROR";
		return ret.toString();	
		
	}
}
