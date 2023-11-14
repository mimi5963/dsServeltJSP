package datastructureEx2;

import java.util.Comparator;

public class heap<T> {
	int size;
	T[] array;
	Comparator<T> com;
	public heap() {
		size= 0;
		array = (T[])new Object[100];
	}
	public void setComp(Comparator<T> com) {
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
	public boolean hIsEmpty() {
		if(size == 0)return true;
		return false;
	}
	public int getHighPriorityChild(int idx) {
		if(getLeftChild(idx) > size)return 0;
		if(getLeftChild(idx) == size) return getLeftChild(idx);
		if(com.compare(array[getLeftChild(idx)], array[getRightChild(idx)]) <0) {
			return getRightChild(idx);
		}
		else return getLeftChild(idx);	
		
	}
	
	public void insertData(T data) {
		int lastDataIdx = size+1;
		
		while(lastDataIdx != 1) {
			if(com.compare(data, array[getParent(lastDataIdx)]) >0) {
				array[lastDataIdx] = array[getParent(lastDataIdx)];
				lastDataIdx = getParent(lastDataIdx);
			}else break;
		}
		array[lastDataIdx] = data;
		size++;
	}
	
	public T deleteValue() {
		T Dedata = array[1];
		T lastData = array[size];
		int lastDataIdx = 1;
		int childIdx;
		
		while(true) {
			childIdx = getHighPriorityChild(lastDataIdx);
			if(com.compare(lastData, array[childIdx]) >=0)
				break;
			array[lastDataIdx] = array[childIdx];
			lastDataIdx = childIdx;
		}
		array[lastDataIdx] = lastData;
		size--;
		
		
		return Dedata;
	}
	
	}
	
	
	

