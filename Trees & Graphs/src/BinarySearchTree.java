
public class BinarySearchTree<T> extends BinaryTree<T>{
	
	// Overriden methods
	@Override
	void insert(Node<T> node) {
		
	}
	
//	@Override
//	boolean deleteNode(Node<T> node) {
//		
//	}
	
	// BST (Integer) Specific methods
	boolean search(Integer data) {
		if (root == null || !(root.data instanceof Integer))
			return false;
		
		Node<Integer> temp = (Node<Integer>) root;
		while (temp != null) {
			if (data == temp.data)
				return true;
			else if (data < (Integer) temp.data)
				temp = (Node<Integer>) temp.left;
			else 
				temp = (Node<Integer>) temp.right;
		}
		return false;
	}
	
	
}
