import java.util.ArrayList;

public class Q6 {
	public static void main(String args[]) {
		LinkedList<Integer> list = new LinkedList<Integer>(4, 2, 3, 5, 8);
		
		// Creating the broken list myself
		list.getNext();
		list.getNext();
		Node looper = list.getCurrent();
		list.getNext();
		list.getNext();
		list.getCurrent().next = looper;
		
		//
		ArrayList<Node<Integer>> buffer = new ArrayList<Node<Integer>>();
		list.restart();
		
		while (!buffer.contains(list.getCurrent())) {
			buffer.add(list.getCurrent());
			list.getNext();
		}
		System.out.println("Node that repeats: " + list.getCurrent().data);
	}
}
