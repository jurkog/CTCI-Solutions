
public class Q7 {

	public static void main(String[] args) {
		LinkedList<Integer> pList = new LinkedList<Integer>(4, 2, 5, 5, 2, 4);
		LinkedList<Integer> list = new LinkedList<Integer>(4, 2, 5, 3, 4);
		
		System.out.println("Is pList a palindrome linked list?: " + isPalindromeLinkedList(pList));
		System.out.println("Is list a palindrome linked list?: " + isPalindromeLinkedList(list));
	}
	
	static boolean isPalindromeLinkedList(LinkedList<Integer> list) {
		LinkedList<Integer> reverse = new LinkedList<Integer>();
		
		// Reversing the list
		while(list.hasNext()) {
			reverse.insertBeginning(list.getCurrent().data);
			list.getNext();
		}
		
		list.restart();
		reverse.restart();
		while (list.hasNext()) {
			if (list.getCurrent().data == reverse.getCurrent().data) {
				list.getNext();
				reverse.getNext();
			} else {
				return false;
			}
		}
		return true;
	}

}
