package TreeAndHeap;

import java.util.Comparator;

public class Heap<T> {
	private int numOfdata;
	T[] arr;
	Comparator<T> com;
	
	public Heap() {
		numOfdata = 0;
		arr = (T[]) new Object[100];
	}
	public void setComparator(Comparator<T> com) {
		this.com = com;
	}
	
	public int getParent(int idx) {
		return idx/2;
	}
	public int getLeftChild(int idx) {
		return idx*2;
	}
	public int getRightChild(int idx) {
		return getLeftChild(idx)+1;
	}
	
	public void insterData(T data) {
		int dataIdx = numOfdata+1;
		
		while(dataIdx != 1) {
			if(com.compare(data, arr[getParent(dataIdx)]) >0) {
				arr[dataIdx] = arr[getParent(dataIdx)];
				dataIdx = getParent(dataIdx);
			}else break;
		}
		
		arr[dataIdx] = data;
		this.numOfdata+=1;
	}
	
	public T deleteData() {
		T dedata = arr[1];
		T lastPriorityData = arr[this.numOfdata];
		int findNewLastPriorityIdx = 1; //last데이터의 자리는 일단 1..
		int childFromRoot;
		while(true) {
			childFromRoot = getMaxPriorityChild(findNewLastPriorityIdx);
			
			if(com.compare(lastPriorityData, arr[childFromRoot]) >= 0) {
				break;
			}
			arr[findNewLastPriorityIdx] = arr[childFromRoot];
			findNewLastPriorityIdx = getMaxPriorityChild(findNewLastPriorityIdx);
		}
		
		arr[findNewLastPriorityIdx] = lastPriorityData;
		return dedata;
		
	}
	
	
	
	
	
	public int getMaxPriorityChild(int idx) {
		if(getLeftChild(idx) > this.numOfdata) {
			return 0;
		}
		if(getLeftChild(idx) == this.numOfdata) {
			return getLeftChild(idx);
		}
		if(com.compare(arr[getLeftChild(idx)],arr[getRightChild(idx)])<0) {
			return getRightChild(idx);
		}else {
			return getLeftChild(idx);
		}
	}
	public boolean isEmpty() {
		if(this.numOfdata == 0) return true;
		return false;
	}
}
