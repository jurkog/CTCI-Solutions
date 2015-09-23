import java.util.LinkedList;

public class Q8 {
	static BinaryTree<Integer> T1 = new BinaryTree<Integer>();
	static BinaryTree<Integer> T2 = new BinaryTree<Integer>();
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			T1.insert(i);
		
		T2.insert(9);		
		System.out.println("Is T2 a subtree of T1? " + isSubTree(T1.root, T2.root));
		
		
	}
	
	static boolean isSubTree(Node<Integer> a, Node<Integer> b) {
		LinkedList<Node<Integer>> q = new LinkedList<Node<Integer>>();
		q.add(a);
		while (!q.isEmpty()) {
			if (subTree(q.peekFirst(), b))
				return true;
			if (q.peekFirst().left != null)q.add(q.peekFirst().left);
			if (q.peekFirst().right != null)q.add(q.peekFirst().right);
			q.removeFirst();
		}
		return false;
	}
	
	static boolean subTree(Node<Integer> a, Node<Integer> b) {
		if (a == null || b == null)
			if (a == null && b == null)
				return true;
			else
				return false;
			
		if (a.data.equals(b.data))
			return subTree(a.left, b.left) && true && subTree(a.right, b.right);
		
		return false;
	}
}
