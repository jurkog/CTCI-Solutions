
public class Node<T> {
	Node<T> left;
	Node<T> right;
	Node<T> parent;
	T data;
	
	Node(T data) {
		this.data = data;
		left = null;
		right = null;
		parent = null;
	}
	
	public String toString() {
		if (data != null)
			return data.toString();
		return null;
	}
}
