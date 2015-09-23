
public class Q4 {
	public static void main(String[] args) {
		Stack<Integer> a = new Stack<Integer>(4, 3, 2, 1);
		Stack<Integer> b = new Stack<Integer>();
		Stack<Integer> c = new Stack<Integer>();	
		towersOfHanoi(a, b, c, 4);
		System.out.println(c);
	}

	private static void towersOfHanoi(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c, int i) {
		if (i == 1) {
			c.push(a.pop().data);
			return;
		} else {
			towersOfHanoi(a, c, b, i - 1);
			towersOfHanoi(a, b, c, 1);
			towersOfHanoi(b, a, c, i - 1);
		}		
	}
}
