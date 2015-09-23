import java.util.*;

public class Q4 {
	public static void main(String args[]) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(5);
		tree.insert(7);
		tree.insert(4);
		tree.insert(6);
		tree.insert(3);
		tree.insert(9);
		tree.insert(2);
		tree.insert(1);
		tree.insert(0);
		tree.insert(8);
		ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>(); // Assuming I don't know size
		getTreeLists(tree.root, list);
		int depth = 0;
		for (LinkedList<Integer> l : list) {
			System.out.println("Items at depth = "+ depth++ + " : " + l);
		}
	}
	
	static void getTreeLists(Node<Integer> root, ArrayList<LinkedList<Integer>> list) {
		getTreeLists(root, list, 0);
	}
	
	static void getTreeLists(Node<Integer> root, ArrayList<LinkedList<Integer>> list, int depth) {
		if (root == null)
			return;
		if (depth >= list.size()) 
			list.add(new LinkedList<Integer>());
		list.get(depth).add(root.data);
		getTreeLists(root.left, list, depth + 1);
		getTreeLists(root.right, list, depth + 1);	
	}
}
