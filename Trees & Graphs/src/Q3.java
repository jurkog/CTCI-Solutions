import java.util.LinkedList;

public class Q3 {
	public static void main(String[] args) {
		int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		int half = (array.length - 1) / 2;
		int i = 0, iMax = 1;
		Node<Integer> treeRoot = null;
		treeRoot = pivot(treeRoot, array, 0, array.length);
		System.out.println("Is the tree balanced? " + Q5.isBST(treeRoot));

	}
	
	static Node<Integer> insertNode(Integer data, Node<Integer> root) {
		if (root == null)
			return new Node<Integer>(data);
		
		if (data <= root.data)
			insertNode(data, root.left);
		else
			insertNode(data, root.right);
		
		return root;
	}
	
	static Node<Integer> pivot(Node<Integer> root, int array[], int beg, int end) {
		// Insert array[half = beg + end / 2] (call it ha
		// recurse left-half (root, array, beg, half)
		// recurse right-half (root, array, half, end)
		int half = (beg + end) / 2;
		root = insertNode(array[half], root);		
		if (beg != half) {
			root = pivot(root, array, beg, half - 1);
			root = pivot(root, array, half + 1, end);
		} 
		return root;
	}	
}