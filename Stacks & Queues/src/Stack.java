import java.util.ArrayList;

public class Stack<T> {
	Node<T> top;
	
	Node<T> pop() {
		if (top != null) {
			Node<T> pop = top;
			top = top.next;
			return pop;
		}
		return null;
	}
	
	void push(T data) {
		push(new Node(data));
	}
	
	void push(Node<T> data) {
		if (top != null) 
			data.next = top;
		top = data;		
	}
	
	Node<T> peek() {
		return top;
	}
	
	Stack(T... args) {
		for (T i: args)
			push(i);
	}
	
	boolean isEmpty() {
		return top == null;
	}
	
	public String toString() {
		if (top == null)
			return null;
		Node<T> temp = top;
		ArrayList<T> ret = new ArrayList<T>();
		while (temp != null) {
			ret.add(temp.data);
			temp = temp.next;
		}
		return ret.toString();	
	}
	
}
