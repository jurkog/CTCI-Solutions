
public class Q2 {
	static Node<Integer> top, min;
	
	public static void main(String[] args) {
		push(3);
		push(5);
		push(8);
		push(2);
		push(9);
		System.out.println(min().data);
		System.out.println(pop().data);
		System.out.println(pop().data);
		System.out.println(min().data);
	}
	
	static Node<Integer> pop() {
		if (top != null) {
			Node<Integer> pop = top;
			top = top.next;
			min = min.next;
			return pop;
		} 
		return null;
	}
	
	static void push(Integer i) {
		Node<Integer> push = new Node<Integer>(i);
		push.next = top;
		top = push;
		Node<Integer> minHead;
		if (min == null || i < min.data) 
			minHead = new Node<Integer>(i);
		else
			minHead = new Node<Integer>(min.data);
			
		minHead.next = min;
		min = minHead;
	}
	
	static Node<Integer> min() {
		return min;
	}
}
