
public class Q2 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList(3, 9, 2, 8, 3, 4, 5, 4, 9, 2);
		int K_INDEX = 4; // 4th to Last element would be 5
		int length = 0;
		
		while (list.hasNext()) {
			length++;
			list.getNext();
		}
		
		list.restart();
		for (int i = 0; i < length - K_INDEX; i++) {
			list.getNext();
		}
		
		System.out.println(K_INDEX+"th to last element is: " + list.getCurrent().data);
	}
}
