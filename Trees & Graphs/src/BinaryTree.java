import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree<T> {
	Node<T> root;
	private ArrayList<Node<T>> array = new ArrayList<Node<T>>();
	
	// Constructors
	BinaryTree(T data) {
		this (new Node<T>(data));
	}
	
	BinaryTree(Node<T> node) {
		if (root == null)
			root = node;
		
		array.add(root);
	}
	
	BinaryTree() {
		root = null;
	}
	
	// Utility functions
	void insert(T data) {
		insert(data != null ? new Node<T>(data) : null);
	}
	
	void insert(Node<T> node) {
		array.add(node);
		
		if (root == null)
			root = node;
		
		if (node != null) {
			if (node != root) {
				int nodePos = array.indexOf(node);
				int parentPos = (nodePos - 1) / 2;
				Node<T> parent = array.get(parentPos);
				if ((nodePos & 1) == 1)
					parent.left = node;
				else
					parent.right = node;
				node.parent = parent;
			}
		}
	}
	
	void insert (T... data) {
		for (T d : data)
			insert(d);
	}
	
	boolean search(T data) {	
		if (root == null)
			return false;
		
		LinkedList<Node<T>> q = new LinkedList<Node<T>>();
		q.add(root);
		while (!q.isEmpty()) {
			Node<T> first = q.removeFirst();
			if (first.data == data)
				return true;
			if (first.left != null) q.add(first.left);
			if (first.right != null) q.add(first.right);
		}
		return false;
	}
	
	protected void deleteNode(Node<T> node) {
		if (node == null)
			return;
		
		int nodePos = array.indexOf(node);
		if (nodePos == -1)
			return;

		Node<T> parent = node.parent;
		if (parent != null) {
			if ((nodePos & 1) == 1)
				parent.left = null;
			else
				parent.right = null;
		}
		
		array.set(nodePos, null);
		deleteNode(node.left);
		deleteNode(node.right);	
	}
	
	void delete(Node<T> node) {
		deleteNode(node);

		// Clean up to remove end null nodes
		int i = array.size();
		while(i-- >= 0 && array.get(i) == null)
			array.remove(i);	
	}
	
	void printInOrder() {
		LinkedList<Node<T>> list = new LinkedList<Node<T>>();
		// Here, we will store the numbers of the tree.
		//        1
		//     2     3
		//   4   5 6   7
		//
		// ==>[4, 2, 5, 1, 6, 3, 7]
		
		// 1	
		// 2 3      //2 1
		// 
		if (root == null)
			return;
		
		LinkedList<Node<T>> q = new LinkedList<Node<T>>();
		q.add(root);
		list.add(root);
		
		while (!q.isEmpty()) {
			Node<T> first = q.peekFirst();
			int indexOfFirst = list.indexOf(first);
			if (first.left != null) {
				list.add(indexOfFirst,first.left);
				q.add(first.left);
			}
			if (first.right != null) {
				list.add(indexOfFirst + 2, first.right);
				q.add(first.right);		
			}
			q.removeFirst();
		}
		System.out.println("List: " + list);
	}
	
	void properPrintInOrder() {
		Node<T> cRoot = root;
		LinkedList<Node<T>> stack = new LinkedList<Node<T>>();
		while (!stack.isEmpty() || cRoot != null) {
			if (cRoot != null) {
				stack.add(cRoot);
				cRoot = cRoot.left;
			} else {
				cRoot = stack.removeLast();
				System.out.print(cRoot.data + " ");
				cRoot = cRoot.right;
			}
		}
	}
}

