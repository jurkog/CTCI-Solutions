
public class Q6 {

	// 4, 7, 1, 3, 5, 9
	// 9, 5, 3, 1, 7, 4 1 = min

	// 5, 7, 1, 9, 3, 4
	//

	// 1, 3, 4, 5, 7, 9
	//

	public static void main(String[] args) {
		Stack<Integer> a = new Stack<Integer>(4, 7, 1, 3, 5, 9), b = new Stack<Integer>();
		boolean sorted = false;
		while (!sorted) { // Keep alternating pops of a and b
			sorted = true; // We will be breaking this condition
			Node<Integer> currentNodeA = a.pop(); // Taking from stack a
			System.out.println("Pop from stack a: " + currentNodeA);
			while (currentNodeA != null) { // Until the list is empty
				int currentValue = currentNodeA.data;
				while (a.peek() != null && a.peek().data > currentValue) {
					b.push(a.pop().data);
					sorted = false;
					System.out.println("a.peek().data: " + b.peek().data + " > currentValue: " + currentValue);
				}
				b.push(currentValue);	
				currentNodeA = a.pop();
				System.out.println("Pop from stack a: " + currentNodeA);
			}

			if (sorted) { // Stack has been sorted after first half of rotations
				while (!b.isEmpty())
					a.push(b.pop().data);
				break;
			}
			
			// If not, we're going to have sort the elements back
			Node<Integer> currentNodeB = b.pop();
			System.out.println("Pop from stack b: " + currentNodeB);
			while (currentNodeB != null) {
				int currentValue = currentNodeB.data;
				while(b.peek() != null && b.peek().data < currentValue) {
					a.push(b.pop().data);
					sorted = false;
					System.out.println("b.peek().data: " + a.peek().data + " < currentValue: " + currentValue);
				}
				a.push(currentValue);
				
				currentNodeB = b.pop();
				System.out.println("Pop from stack b: " + currentNodeB);
			}
		}
		
		while (!a.isEmpty()) {
			System.out.println("Value from pop: " + a.pop());
		}
	}
}
