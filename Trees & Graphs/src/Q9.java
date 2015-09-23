import java.util.LinkedList;
import java.util.*;

public class Q9 {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(1,3,2,4,5,3,6,8,1,3,2,1,2,2,2);
		printPaths(tree, 8);
	}
	
	static void printPaths(BinaryTree<Integer> tree, int num) {
		LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(tree.root);
		while (!queue.isEmpty()) {
			Node<Integer> root = queue.removeFirst();
			findPaths(root, "", 0, num);
			if (root.left != null) queue.add(root.left);
			if (root.right != null) queue.add(root.right);
		}	
	}
	
	static void findPaths(Node<Integer> root, String path, int pathSum, int num) {
		if (root == null)
			return;
		
		pathSum += root.data;
		path += " " + root.data;
		
		if (pathSum > num) {
			return;
		} else if (pathSum == num) {
			System.out.println("Path:" + path);
		} else {
			findPaths(root.left, path, pathSum, num);
			findPaths(root.right, path, pathSum, num);
		}		
	}
}
