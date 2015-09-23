
public class Q4 {

	public static void main(String[] args) {		
		Integer x = 4;
		Node<Integer> pivot;
		LinkedList<Integer> list = new LinkedList<Integer>(2,6,3,5,x,8,7,3,2,5);
		System.out.println("Unpartitioned list:");
		list.printList();
		
		list.restart();
		while (list.hasNext() && list.getCurrent().data != x)
			list.getNext();
		
		pivot = list.getCurrent();
		
		Node upper = null, lower = null, upperStart = null, lowerStart = null;
		
		Node<Integer> n = list.head;
		while(n != null) {
			Node run = n.next;
			if (n.data < x)
				if (lower == null)
					lowerStart = lower = n;
				else 
					lower = lower.next = n;
			else if (n.data > x)
				if (upper == null)
					upperStart = upper = n;
				else
					upper = upper.next = n;	
			
			n = run;
		}
		upper.next = null;
		lower.next = pivot;
		pivot.next = upperStart;
		list.head = lowerStart;
		
		System.out.println("Partioned List");
		list.printList();
	}

}

