package datastructure.heap;

import java.util.Arrays;
import java.util.Comparator;

public class SortEx {

	public static void main(String[] args) {
		int[] arr = {1,5,9,7,8,11,23,2,6,3};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
		int[] arr2 = {1,5,9,7,8,11,23,2,6,3};
		mergeSort(arr2,0,arr2.length-1);
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = {1,5,9,7,8,11,23,2,6,3};
		
		Comparator<Integer> c = (a,b) -> {
			return (a-b)*-1;
		};
		
		Heap a = new Heap(c);
		
		for(int i : arr3) {
			a.insert(i);
		}
		for(int i=0; i<arr3.length;i++) {
			arr3[i] = a.delete();
		}
		System.out.println(Arrays.toString(arr3));
	}
	
	
	public static void InsertSort(int[] arr) {
		
		int i,j;
		for( i= 1; i< arr.length;i++) {
			
			int insertValue = arr[i];
			
			for( j= i-1; j>=0;j--) {
				if(insertValue < arr[j]) {
					arr[j+1] = arr[j];
				}else break;
			}
			arr[j+1] = insertValue;
			
		}
		
	}
	
	public static void mergeSort(int[] arr, int left, int right) {
		int mid;
		if(left< right) {
			mid = (left+right)/2;
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+1,right);
			mergeSum(arr,mid,left,right);
			
		}
	}
	
	public static void quickSort (int[] arr, int left, int right) {
		
		if(left<=right) {
			int pivot = partion(arr,left,right);
			quickSort(arr,left,pivot-1);
			quickSort(arr,pivot+1,right);
		}
		
	}

	private static int partion(int[] arr, int left, int right) {
		int pivotValue = arr[left];
		int low = left+1;
		int high = right;
		
		while(low <= high) {
			
			while(low<=right && pivotValue <= arr[low])
				low++;
			while(high >= (left+1) && pivotValue >= arr[high])
				high--;
			
			if(low <= high)
				swap(arr,low,high);
			
		}
		

		swap(arr,left,high);
		
		return high;
	}
	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx2];
		arr[idx2] = arr[idx1];
		arr[idx1] = temp;
	}


	private static void mergeSum(int[] arr, int mid, int left, int right) {
		int startLeft = left;
		int startRight = mid+1;
		int Idx = left;
		int[] newarr = new int[right+1];
		
		while(startLeft <= mid && startRight <= right) {
			if(arr[startLeft] < arr[startRight]) {
				newarr[Idx] = arr[startRight++];
			}else {
				newarr[Idx] = arr[startLeft++];
			}
			Idx++;
		}
		
		if(startLeft > mid) {
			for(int i = startRight; i<=right; i++) {
				newarr[Idx++] = arr[i];
			}
		}else {
				
				for(int i=startLeft; i<=mid;i++) {
					newarr[Idx++] = arr[i];
				}
			}
		
		for(int i = left ; i<=right; i++) {
			arr[i] = newarr[i];
		}
		
	}
}

class Heap {
	int num;
	int[] arr;
	Comparator<Integer> com;
	
	public Heap(Comparator<Integer> com) {
		this.com = com;
		num =0;
		arr = new int[100];
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
	public int getHiPriorityChild(int idx) {
		if(getLeftChild(idx) > num) return 0;
		if(getLeftChild(idx) == num) return getLeftChild(idx);
		
		if(com.compare(arr[getLeftChild(idx)], arr[getRightChild(idx)])<0) {
			return getRightChild(idx);
		}else return getLeftChild(idx);
	}
	
	public void insert(int data) {
		int newDataIdx = num+1;
		
		while(newDataIdx != 1) {
			
			if(com.compare(data, arr[getParent(newDataIdx)]) > 0) {
				arr[newDataIdx] = arr[getParent(newDataIdx)];
				newDataIdx = getParent(newDataIdx);
			}else break;
			
		}
		arr[newDataIdx] = data;
		num++;
	}
	public int delete() {
		int Dedata = arr[1];
		
		int lastData = arr[num];
		int lastDataIdx = 1;
		int child;
		
		while(true) {
			child = getHiPriorityChild(lastDataIdx);
			
			if(child == 0 || com.compare(lastData, arr[child]) >= 0) 
				break;
			
			arr[lastDataIdx] = arr[child];
			lastDataIdx = child;
		}
		arr[lastDataIdx] = lastData;
		num--;
		
		return Dedata;
	}
	
}
