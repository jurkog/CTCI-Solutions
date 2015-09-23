
public class LinkedList<T> {
	Node<T> currentNode, previousNode;
	Node<T> head;
	
	LinkedList() {
		previousNode = currentNode = head = null;
	}
	
	LinkedList(T... args) {
		this();
		for (T i : args)
			insertNodeAtEndOfList(i);
	}
	
	Node<T> getCurrent() {
		return currentNode;
	}
	
	boolean hasNext() {
		return currentNode != null;
	}
	
	void getNext() {
		if (hasNext()) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

	}
	
	boolean emptyList() {
		return head == null;
	}
	
	boolean endOfList() {
		return !emptyList() && !hasNext();
	}
	
	void insertNodeAfterCurrent(T data) {
		if (endOfList())
			currentNode.appendToTail(data);
		else if(emptyList())
			head = currentNode = new Node(data);
		else {
			Node connect = currentNode.next;
			currentNode.next = new Node(data);
			currentNode.next.next = connect;
		}
	}
	
	void insertNodeAtEndOfList(T data) {
		if (emptyList())
			head = currentNode = new Node(data);
		else
			head.appendToTail(data);
	}
	
	void restart() {
		currentNode = head;
		previousNode = null;
	}
	
	void printList() {
		Node n = head;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

	public Node removeNode(Node n) {
		Node h = head;
		if (h == n) {
			head = head.next;
		} else if (n.next == null) {
			while (h.next != n) 
				h = h.next;
				h.next = null;
		} else {
			while (h.next != n)
				h = h.next;
			h.next = n.next;
		}	
		n.next = null;
		return n;
	}

	public void insertBeginning(T i) {
		Node newHead = new Node(i);
		newHead.next = head;
		head = newHead;
		if (currentNode == null)
			currentNode = head;
	}
}




