package datastructure.heap;

import java.util.Comparator;

public class Heapimpl<T> {
	int numOfdata;
	T[] array;
	Comparator<T> cm;
	public Heapimpl() {
		this.numOfdata = 0;
	
	}
	public void setComparator(Comparator<T> com) {
		this.cm = com;
	}
	
	public int getParentIdx(int idx) {
		return idx/2;
	}
	public int getLeftChildIdx(int idx) {
		return idx*2;
	}
	public int getRightChildIdx(int idx) {
		return getLeftChildIdx(idx)+1;
	}
	
	public void InsertData(T data) throws Exception {
		if(cm == null) {
			throw new Exception("지정해");
		}
		int idx = numOfdata+1; //새로 추가된 elem의 위치
		
		while(idx != 1) {
			if(cm.compare(data, array[getParentIdx(idx)])>0 ) {
				array[idx] = array[getParentIdx(idx)];
				idx = getParentIdx(idx);
			}else break;
		}
		
		array[idx] = data;
		this.numOfdata +=1;
	}
	public T deleteData() {
		T rdata = array[1];
		int startIdx = 1; //마지막 elem의 위치
		int childidx;
		T lastElem = array[numOfdata];
		
		while(true) {
			childidx = getMaxIndexOfChild(startIdx);
			if(cm.compare(lastElem, array[childidx]) >= 0) 
				break;
				
			array[startIdx] = array[childidx];
			startIdx = childidx;
			
		}
		
		array[startIdx] = lastElem;
		
		return rdata;
	}
	
	public int getMaxIndexOfChild(int idx) {
		if(getLeftChildIdx(idx) > numOfdata)
			return 0;
		if(getLeftChildIdx(idx) == numOfdata)
			return getLeftChildIdx(idx);
		if(cm.compare(array[getLeftChildIdx(idx)], array[getRightChildIdx(idx)])<0) {
			return getRightChildIdx(idx);
		}else {
			return getLeftChildIdx(idx);
		}
	}
	public boolean isEmpty() {
		if(numOfdata == 0) return true;
		return false;
	}
	
	
}
