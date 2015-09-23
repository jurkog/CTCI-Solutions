import java.util.*;

public class Q7 {
	
	private static Cat lastCat = null;
	private static Dog lastDog = null;
	
	private static LinkedList<Animal> queue = new LinkedList<Animal>();
	
	public static void main(String[] args) {
		
		enqueue(new Dog("Dog 1"));
		enqueue(new Dog("Dog 2"));
		enqueue(new Cat("Cat 1"));
		enqueue(new Dog("Dog 3"));
		enqueue(new Cat("Cat 2"));
		enqueue(new Dog("Dog 4"));
		
		System.out.println("Cat dequeue: " + dequeueCat().name);
		System.out.println("Any dequeue: " + dequeueAny().name);
		System.out.println("Dog dequeue: " + dequeueDog().name);
		System.out.println("Cat dequeue: " + dequeueCat().name);
	}
	
	public static void enqueue(Animal a) {
		if (a instanceof Cat)
			if (lastCat == null)
				lastCat = (Cat) a;
		if (a instanceof Dog)
			if (lastDog == null)
				lastDog = (Dog) a;
		queue.add(a);
	}
	
	public static Cat dequeueCat() {
		int index = queue.indexOf(lastCat);
		int i = index + 1;
		lastCat = null;
		while (i < queue.size() - 1 && lastCat == null) {
			if (queue.get(i) instanceof Cat)
				lastCat = (Cat) queue.get(i);
			i++;
		}
		return (Cat) queue.get(index);
	}
	
	public static Dog dequeueDog() {
		int index = queue.indexOf(lastDog);
		int i = index + 1;
		lastDog = null;
		while (i < queue.size() - 1 && lastDog == null) {
			if (queue.get(i) instanceof Dog)
				lastDog = (Dog) queue.get(i);
			i++;
		}
		return (Dog) queue.get(index);
	}
	
	public static Animal dequeueAny() {
		Animal last = queue.getLast();
		if (last != null)
			if (last instanceof Cat)
				return dequeueCat();
			else
				return dequeueDog();
		return null;
	}
}

class Animal {
	protected String name;
	Animal(String name) {this.name = name;}
}
class Dog extends Animal {
	Dog(String name) {super(name);}
}
class Cat extends Animal {
	Cat(String name) {super(name);}
}
