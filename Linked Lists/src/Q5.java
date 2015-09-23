
public class Q5 {

	public static void main(String[] args) {
		LinkedList<Integer> a, b, sum;
		
		// Initializing numbers
		a = new LinkedList<Integer>(6, 1, 7);
		b = new LinkedList<Integer>(2, 9, 5);
		
		// Calculating sum and returning it into a new LinkedList
		sum = reverseSum(a, b);
		
		// Output
		System.out.println("Reverse sum");
		sum.printList();
		
		// Forward sum
		System.out.println("Forward sum");
		sum = forwardSum(a, b);
		sum.printList();
	}
	
	static LinkedList<Integer> reverseSum(LinkedList<Integer> a, LinkedList<Integer> b) {
		int carry = 0;
		LinkedList<Integer> sum = new LinkedList<Integer>();
		
		while (a.hasNext() || b.hasNext()) {
			int aSum = (a.hasNext()) ? a.getCurrent().data : 0;
			int bSum = (b.hasNext()) ? b.getCurrent().data : 0;
			int cSum = aSum + bSum;
			
			sum.insertNodeAtEndOfList((cSum % 10) + carry);
			carry = cSum / 10;
			a.getNext();
			b.getNext();
		}
		
		if (carry == 1)
			sum.insertNodeAfterCurrent(1);
		
		return sum;
	}
	
	static LinkedList<Integer> forwardSum(LinkedList<Integer> a, LinkedList<Integer> b) {
		// 2, 4, 6		== 0, 2, 4, 6
		// 4, 2, 6, 7	== 4, 2, 6, 7
		
		// sum = 3
		// sum = 0 + 1, 3
		// sum = 4 + 1, 1, 3
		// sum = 4, 5, 1, 3
		
		
		// Inserting zeroes at the front positions
		while (!a.endOfList() || !b.endOfList()) {
			if (!a.hasNext())
				a.insertBeginning(0);
			if (!b.hasNext())
				b.insertBeginning(0);
			a.getNext();
			b.getNext();
		}
		
		// Restarting
		a.restart();
		b.restart();
		
		// Call rescursive call
		LinkedList<Integer> sum = new LinkedList<Integer>();
		int carry = recursiveCall(a, b, sum);
		if (carry == 1)
			sum.insertBeginning(1);
		return sum;
	}

	// 2, 4, 6		== 0, 2, 4, 6
	// 4, 2, 6, 7	== 4, 2, 6, 7
	
	// last call: 		sum = {3} return 1
	// 2nd last call:	sum = {1, 3} return 1
	// 3rd last call: 	sum = {5, 1, 3} return 0;
	// 4th last call: 	sum = {4, 5, 1, 3} return 0;
	
	private static int recursiveCall(LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> sum) {
		int data = a.getCurrent().data + b.getCurrent().data;
		a.getNext();
		b.getNext();
		  
		sum.insertBeginning((data % 10) + (!a.hasNext() && !b.hasNext() ? 0 : recursiveCall(a, b, sum)));
			
		return data / 10;
	}
}
