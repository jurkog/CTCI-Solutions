
public class Q6 {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(20, 8, 22, 4, 12, null, null, null, null, 10, 14);
		System.out.println(tree.root);
		System.out.println("InOrder of 8: " + inOrderSuccesor(tree.root.left));
		System.out.println("InOrder of 10: " + inOrderSuccesor(tree.root.left.right.left));
		System.out.println("InOrder of 14: " + inOrderSuccesor(tree.root.left.right.right));
	}
	
	static Node<Integer> inOrderSuccesor(Node<Integer> root) {
		if (root == null)
			return null;
		
		if (root.right != null)
			return findMin(root.right);
		
		Node<Integer> parent = root.parent;
		while (parent.data < root.data)
			parent = parent.parent;
		
		return parent;
	}
	
	static Node<Integer> findMin(Node<Integer> root) {
		if (root == null)
			return null;
		
		while (root.left != null)
			root = root.left;
		
		return root;
	}
	
	static void InOrder(Node<Integer> root) {
		if (root == null || root.data == null)
			return;
		
		if (root.left != null) InOrder(root.left);
		System.out.println(root.data);
		if (root.right != null) InOrder(root.right);
	}
	
	
}


