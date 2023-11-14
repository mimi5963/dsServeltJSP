package datastructure.heap;

import java.util.Comparator;

public class PriorityQueue<T> {
	
	private Heapimpl<T> Heapimpl;
	T data;
	public PriorityQueue() {
		Heapimpl = new Heapimpl<T>();
	}
	public void setComp(Comparator<T> cm) {
		Heapimpl.setComparator(cm);
	}
	
	public boolean PQIsEmpty() {
		return Heapimpl.isEmpty();
	}
	
	void PEnqueue(T data) {
		try {
			Heapimpl.InsertData(data);
		} catch (Exception e) {
			System.out.println("비교기준 정의해야함");
		}
	}
	T PDequeue() {
		return Heapimpl.deleteData();
	}
	
	
}
