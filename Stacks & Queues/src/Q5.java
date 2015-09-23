
public class Q5<T> {
		private Stack<T> e = new Stack<T>(), d = new Stack<T>();
		
		public static void main(String args[]) {
			Q5<Integer> MyQueue = new Q5<Integer>(5, 4, 3, 5, 4);
			while (!MyQueue.isEmpty())
				System.out.println("Element dequeued: " + MyQueue.dequeue());
		}
		
		public void enqueue(T data) {
			if (e.isEmpty()) {
				while (!d.isEmpty())
					e.push(d.pop().data);
			}
			e.push(data);
		}
		
		public T dequeue() {
			if (d.isEmpty()) {
				while (!e.isEmpty()) {
					d.push(e.pop().data);
				}
			}
			return d.pop().data;
		}
		
		public boolean isEmpty() {
			return e.isEmpty() && d.isEmpty();
		}
		
		Q5(T... args) {
			for (T arg : args)
				enqueue(arg);
		}
}
