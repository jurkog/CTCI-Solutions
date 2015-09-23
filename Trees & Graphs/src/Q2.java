import java.util.*;

class Vertex {
	ArrayList<Vertex> paths = new ArrayList<Vertex>();
	int data;
	Vertex(int data) { this.data = data; }
	boolean doesPathExist(Vertex find) {
		if (this.data == find.data) {
			return true;
		}
		
		for (Vertex v : paths) {
			if (v.doesPathExist(find))
				return true;
		}
		return false;
	}
}

public class Q2 {

	public static void main(String[] args) {
		Vertex v[] = new Vertex[20];
		for (int i = 0; i < 20; i++)
			v[i] = new Vertex(i);
		
		addEdge(v[0], v[5]);
		addEdge(v[5], v[2]);
		addEdge(v[2], v[1]);
		addEdge(v[5], v[4]);
		addEdge(v[4], v[3]);
		
		System.out.println("v[0] -> v[4] ? " + v[5].doesPathExist(v[4]));	
	}
	
	static void addEdge(Vertex start, Vertex destination) {
		start.paths.add(destination);
	}
}


