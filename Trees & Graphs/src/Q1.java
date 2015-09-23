
public class Q1 {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
		
		// My insert function already places new nodes in order.
		for (int i = 0; i < 8; i++)
			tree.insert(i);
		
		System.out.println("Tree height: " + findHeight(tree.root));
		System.out.println("Is it balanced?: " + isBalancedTree(tree.root));
		
		Node<Integer> left = tree.root;
		while (left.left != null)
			left = left.left;
		left.left = new Node<Integer>(9);
		left.left.left = new Node<Integer>(10);
		left.right = new Node<Integer>(11);
		left.right.right = new Node<Integer>(12);
		left.right.right.left = new Node<Integer>(13);
		
		System.out.println("New tree height: " + findHeight(tree.root));
		System.out.println("Is it balanced?: " + isBalancedTree(tree.root));
		
	}
	
	static int findHeight(Node<Integer> root) {
		if (root == null)
			return -1;
		
		return Math.max(1 + findHeight(root.left), 1 + findHeight(root.right));
	}
	
	static boolean isBalancedTree(Node<Integer> root) {
		if (root == null)
			return true;
		if (Math.abs(findHeight(root.left) - findHeight(root.right)) > 1)
			return false;
		return isBalancedTree(root.left) && isBalancedTree(root.right);
	}
}
