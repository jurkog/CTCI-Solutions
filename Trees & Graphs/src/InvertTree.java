
public class InvertTree {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(7, 4, 9, 3, 2, 0, 5);
		System.out.println("List: " + tree);
		invertTree(tree.root);
		System.out.println("Inverted: " + tree.root);
		
	}
	
	static void invertTree(Node<Integer> root) {
		if (root == null)
			return;
		
		Node<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);
	}
	
	static Node<Integer> invertTest (Node<Integer> root) {
		if (root == null)
			return null;
		Node<Integer> temp = root.left;
		root.left = invertTest(root.right);
		root.right = invertTest(temp);
		return root;	
	}
}
