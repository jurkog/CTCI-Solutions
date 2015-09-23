
public class Q7 {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		for (int i = 1; i <= 8; i++)
			tree.insert(i);
		
		lca(tree.root, 4, 5);
		lca(tree.root, 4, 6);
		lca(tree.root, 3, 4);
		lca(tree.root, 2, 4);
		lca(tree.root, 8, 4);
	}
	
	static boolean lca(Node<Integer> root, int a, int b) {
		if (root == null)
			return false;
		
		boolean data = root.data == a || root.data == b;
		boolean left = lca(root.left, a, b);
		boolean right = lca(root.right, a, b);
		
		if (left || right) {
			if (left && right || data) 
				System.out.println("a: " + a + " b: " + b + " lca: " + root.data);
		}		
	
		return left || right || data;
	}
}
