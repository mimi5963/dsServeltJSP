package datastructure.heap;

import java.util.Comparator;

public class HeapElem<T> implements Comparable<HeapElem<T>>{
	int priority;
	T data;
	Comparable<HeapElem<T>> com;
	
	public HeapElem(T data, int pr) {
		this.data =data;
		this.priority =pr;
	}
	public void setComparable(Comparable<HeapElem<T>> c) {
		this.com = com;
	}


	@Override
	public int compareTo(HeapElem<T> o) {
		if(com != null) {
			return com.compareTo(o);
		}
		
		return this.priority-o.priority; //우선순위는 pr이 작을수록 높음 0은같음 0보다크면->현재가 우선순위 낮음 반대는 반대 
	}

	
}
