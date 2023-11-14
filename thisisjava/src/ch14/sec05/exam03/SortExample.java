package ch14.sec05.exam03;

import java.util.Arrays;
import java.util.Comparator;

public class SortExample {

	public static void main(String[] args) {
		Integer[] arr = {5,11,2,6,8,10,7,4,9};
	
		//힙정렬
		Comparator<Integer> c = (a,b)->{
			return b-a;
		};
		Heaps<Integer> h = new Heaps<>(c);
		
		for(Integer i : arr) {
			h.InsertData(i);
		}
		
		for(int i=0; i<arr.length;i++) {
			arr[i] = h.deleteData();
		}
		System.out.println(Arrays.toString(arr));
		
		//합병정렬
		int[] arr2 = {5,11,2,6,8,10,7,4,9};
		mergeSort(arr2,0,arr2.length-1);
		System.out.println(Arrays.toString(arr2));
		
		//퀵정렬
		int[] arr3 = {5,11,2,6,8,8,8,10,7,4,9};
		quickSort(arr3,0,arr3.length-1);
		System.out.println(Arrays.toString(arr3));
		
	}

	private static void quickSort(int[] arr3, int left, int right) {
		if(left <= right) {
			int pivot = partition(arr3,left,right);
			quickSort(arr3,left,pivot-1);
			quickSort(arr3,pivot+1,right);
		}
		
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = left;
		int low = left;
		int high = right;
		
		while(low <= high) { //low>high하면서 끝남
			while(low <= right && arr[pivot] >= arr[low])
				low++;
			while( high >= (left+1)&&  arr[pivot] <= arr[high])
				high--;
			
			if(low<=high)
				swap(arr,low,high);
		}
		
		swap(arr,pivot,high);
		
		return high;
	}
	private static void swap(int[] arr,int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	private static void mergeSort(int[] arr, int left, int right) {
		int mid;
		if(left<right) {
			mid =(left+right)/2;
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
		
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int startLeft = left;
		int startRight = mid+1;
		int newArrayIdx =left;
		int[] newarr = new int[right+1];
		
		while(startLeft <=mid && startRight <= right) {
			if(arr[startLeft] > arr[startRight]) {
				newarr[newArrayIdx] = arr[startRight++];
			}else {
				newarr[newArrayIdx] = arr[startLeft++];
			}
			newArrayIdx++;
		}
		if(startLeft > mid) {
			for(int i=startRight;i<=right;i++) {
				newarr[newArrayIdx++] = arr[i];
			}
		}else {
			for(int i=startLeft;i<=mid;i++) {
				newarr[newArrayIdx++] = arr[i];
			}
		}
		for(int i=left;i<=right;i++) {
			arr[i] = newarr[i];
		}
	}
	
}



class Heaps<T>{
	int num;
	T [] array;
	Comparator com;
	
	public Heaps(Comparator c) {
		com = c;
		num =0;
		array = (T[])new Object[100];
		
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
	public int getMaxChildIdx(int idx) {
		if(getLeftChild(idx) > num)return 0;
		if(getLeftChild(idx) == num)return getLeftChild(idx);
		
		if(com.compare(array[getLeftChild(idx)], array[getRightChild(idx)])<0) {
			return getRightChild(idx);
			
		}else return getLeftChild(idx);
	}
	public void InsertData(T data) {
		int dataIdx = num+1;
		while(dataIdx != 1) {
			if(com.compare(data, array[getParent(dataIdx)]) > 0) {
				array[dataIdx] = array[getParent(dataIdx)];
				dataIdx = getParent(dataIdx);
			}else break;
		}
		array[dataIdx] = data;
		num++;
	}
	public T deleteData() {
		T Dedata = array[1];
		T lastData = array[num];
		int lastDataIdx = 1;
		int child;
		while(true) {
			child = getMaxChildIdx(lastDataIdx);
			if(child ==0||com.compare(lastData, array[child]) >=0) {
				break;
			}
			array[lastDataIdx] = array[child];
			lastDataIdx = child;
		}
		array[lastDataIdx] = lastData;
		num--;
		return Dedata;
	}
}

