import java.util.LinkedList;

public class Q5 {
	static LinkedList<Integer> queue;
	public static void main(String args[]) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(5);
		tree.insert(2);
		tree.insert(7);
		tree.insert(1);
		tree.insert(3);
		tree.insert(6);
		tree.insert(8);		
		tree.insert(0);
		tree.insert(2);
		tree.insert(2);
		tree.insert(4);		
		tree.insert(4);
		System.out.println("Is 'tree' a BST? " + isBST(tree.root));
		
	}
	

	static void InOrder(Node<Integer> node) {
		if (node == null)
			return;

		InOrder(node.left);
		queue.add(node.data);
		InOrder(node.right);
	}
	
	static boolean isBST(Node<Integer> root) {
		 queue = new LinkedList<Integer>();
		 InOrder(root);
		 int min = queue.removeFirst();
		 while (!queue.isEmpty())
			 if (queue.peekFirst() < min)
				 return false;
			 else
				 min = queue.removeFirst();
		return true;
	}
}
