import java.util.ArrayList;

// Assumptions
// 1. I can't use an array to indicate a new stack
// 2. I can implement this 'stack of plates' any way I want
//	so I've decided I'm going to implement it as a stack of stack of plates

// Also: Instead of calling it set of stacks
//		to continue my current question numbering
//		convention, Im just calling it Q3

// Follow up assumption -> A normal stack of plates we shouldn't care if every stack is at its full capacity or we would
// lose a lot of time taking plates from the bottom and bring them to the top.
// I decided that if we keep track of stacks at which plates got removed, we can try to push them there first.


public class Q3 {
	static Stack<Stack<Integer>> top = new Stack<Stack<Integer>>();
	final static int MAX_STACK_SIZE = 4;
	static int topSize = MAX_STACK_SIZE;
	static int indexOfTop = -1;
	static ArrayList<Integer> pushBuffer = new ArrayList<Integer>();
	
	public static void main(String args[]) {
		push(4);
		push(3);
		push(2);
		push(1);
		push(5);
		push(6);
		
		System.out.println("Pop at stack index 0: " + popAt(0));
		System.out.println("Pop at stack index 0: " + popAt(0));
		System.out.println("Pushing a new value 3");
		push(3);
		for (int i = 0; i < 4; i++)
			System.out.println(pop());
		
	}
			
	private static Node<Integer> popAt(int index) {
		if (indexOfTop - index < 0)
			return null;
			
		Node<?> buffer[] = new Node<?>[indexOfTop - index];
		for (int i = 0; i < indexOfTop - index; i++) {
			buffer[i] = top.pop();
		}
		Node<Integer> pop = top.peek().data.pop();
		
		for (int i = buffer.length - 1; i >= 0; i--)
			top.push((Stack<Integer>) buffer[i].data);
		if (pop != null)
			pushBuffer.add(index);
		return pop;
	}

	static Node<Integer> pop() {
		if (top.peek() != null) { // Check if most current stack is empty	
			Node<Integer> pop = top.peek().data.pop();
			 	// Check if most current stack .pop() is empty
			if (pop == null) { // If it is empty
				top.pop();	
				System.out.println("Current stack empty! Removing " + indexOfTop--);// remove the stack
			if (top.peek() == null) {
					// Empty OVERALL stack
					System.out.println("Stack fully empty!");
					return null;
				}

				else {
					// Popped stack is not empty
					
					// Checking out if some plates in the stack are missing
					int updateSize = 0;
					while (pushBuffer.remove((Integer)indexOfTop))
						updateSize++;
					topSize = (topSize == 0) ? 3 - updateSize : topSize--;	
					return top.peek().data.pop();
				}
			} else {
				// Checking out if some plates in the stack are missing
				int updateSize = 0;
				while (pushBuffer.remove((Integer)indexOfTop))
					updateSize++;
				topSize = (topSize == 0) ? 3 - updateSize : topSize--;
				return pop;
			}
		}	
		return null;
	}
	
	static void push(Integer i) {
		// This is for the follow up -> Fill up any stacks we called popAt() from
		if (pushBuffer.size() != 0) {
			int index = pushBuffer.remove(0);
			if (index != indexOfTop && index < indexOfTop) {
				Node<?> buffer[] = new Node<?>[indexOfTop - index];
				for (int j = 0; j < indexOfTop - index; j++) {
					buffer[j] = top.pop();
				}
				top.peek().data.push(i);
				for (int j = buffer.length - 1; j >= 0; j--) {
					top.push((Stack<Integer>) buffer[j].data);
				}
				return;
			}
		}
			
		if (topSize == MAX_STACK_SIZE) {
			top.push(new Stack<Integer>());
			System.out.println("New stack created! " + indexOfTop++);
		}

		top.peek().data.push(i);
		topSize = (topSize == MAX_STACK_SIZE) ? 1 : topSize + 1;	
	}
}
