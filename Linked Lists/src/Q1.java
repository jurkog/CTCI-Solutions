import java.util.ArrayList;

public class Q1 {
	public static void main(String args[]) {
		// Array
		Integer nums[] = new Integer[]{2, 7, 9, 9, 3, 2, 4, 5, 9, 2, 3};
		printBufferedList(nums);
		System.out.println("Buffered vs Unbuffered");
		printUnbufferedList(nums);
	}

	private static void printUnbufferedList(Integer[] nums) {
		LinkedList list = new LinkedList();
		for (int i = 0; i < nums.length; i++)
			list.insertNodeAtEndOfList(nums[i]);
		
		while (list.hasNext()) {
			Node n = list.getCurrent();
			while (n != null && n.next != null) {
				if (n.next.data == list.getCurrent().data) {
					n.next = n.next.next;
				}
				n = n.next;
			}
			list.getNext();
		}
		
		list.printList();
		
	}

	private static void printBufferedList(Integer[] nums) {
		LinkedList list = new LinkedList();
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++)
			list.insertNodeAtEndOfList(nums[i]);
		
		while (list.hasNext()) {
			if (numList.contains(list.currentNode.data)) {
				// Deleting node
				list.previousNode.next = list.currentNode.next;
				list.currentNode = list.currentNode.next;
			} else {			
				// Adding currentNode data to our ArrayList
				numList.add((Integer)list.currentNode.data);
				list.getNext();
			}

		}
		
		list.printList();
	}
}
