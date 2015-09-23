
public class Q1 {
	
	final static int ARRAY_SIZE = 9;
	static Integer array[] = new Integer[ARRAY_SIZE];
	
	public static void main(String args[]) {
		StackArray s1 = new StackArray(0, ARRAY_SIZE / 3, array);
		StackArray s2 = new StackArray(ARRAY_SIZE / 3, 2 * ARRAY_SIZE / 3, array);
		StackArray s3 = new StackArray(2 * ARRAY_SIZE / 3, ARRAY_SIZE, array);
		s1.push(5);
		s1.push(4);
		s1.push(3);
		s2.push(2);
		s2.push(1);
		s3.push(0);
		
		System.out.println(s2.pop());
		System.out.println(s2.peek());
		System.out.println(s3.pop());
		System.out.println(s1.pop());
		System.out.println(s1.peek());
		
	}
	
	public static class StackArray {
		int lowerBound, upperBound, top = -1;
		Integer data[];
		
		StackArray(int lower, int upper, Integer array[]) {
			this.lowerBound = lower;
			this.upperBound = upper - 1;
			data = array;
		}
		
		Integer pop() {
			if (top != -1) {
				Integer pop = data[lowerBound + top];
				data[lowerBound + top--] = null;
				return pop;
			}	
			return null;
		}
		
		void push(int i) {
			if (top != upperBound - lowerBound) {
				data[lowerBound + ++top] = i;
			}
		}
		
		Integer peek() {
			if (top != -1)
				return data[lowerBound + top];
			return null;
		}
	}
}
