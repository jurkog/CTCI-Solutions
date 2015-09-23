
public class Node<T> {
	T data;
	Node next = null;
	
	Node(T data) {
		this.data = data;
	}
	
	void appendToTail(T data) {
		Node end = new Node(data);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public String toString() {
		return data.toString();
	}
}
