
public class Q3 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(1,2,8,7,9);
		list.getNext();
		list.getNext();
		deleteNode(list.getCurrent());
		list.printList();
	}
	
	static void deleteNode(Node n) {
		n.data = n.next.data;
		n.next = n.next.next;
	}

}
