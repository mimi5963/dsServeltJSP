package TreeAndHeap;

import java.util.Comparator;

public class PriorityQueue<T> {
	Heap<T> h;
	
	public PriorityQueue() {
		h = new Heap<T>();
	
	}
	
	public boolean pqIsEmpty() {
		return h.isEmpty();
	}
	
	public void PEnqueue(T data) {
		h.insterData(data);
	}
	public T deleteData() {
		return h.deleteData();
	}
	public void setComparator(Comparator<T> comp) {
		h.setComparator(comp);
	}
}
