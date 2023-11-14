package SimpleSort;

import java.util.Arrays;
import java.util.Random;

public class SimpleSortEx3 {

	public static void main(String[] args) {
	  Random r = new Random(System.currentTimeMillis());
	
	  
	  int[] arr =new int[100];
	  int[] arr2 = new int[100];
	 

	  for(int i=0; i<100; i++) {
		  arr[i] = r.nextInt(100);
		  arr2[i] = r.nextInt(100);
	  }
	  System.out.println(Arrays.toString(arr));
	  mergeSort(arr,0,arr.length-1);
	  quickSort(arr2,0,arr2.length-1);
	  System.out.println(Arrays.toString(arr));
	  System.out.println(Arrays.toString(arr2));
	  
	}
	
	public static void mergeSort(int[] arr,int left, int right) {
		int mid;
		if(left < right) {
			 mid = (left+right)/2;
			 mergeSort(arr,left,mid);
			 mergeSort(arr,mid+1,right);
			 mergeSum(arr,mid,left,right);
		}
	}

	private static void mergeSum(int[] arr, int mid, int left, int right) {
		int startLeft = left;
		int startRight = mid+1;
		int Idx = left;
		int[] newarr = new int[right+1];
		
		while(startLeft <=mid && startRight <= right) {
			if(arr[startLeft] > arr[startRight]) {
				newarr[Idx] = arr[startRight++];
			}else {
				newarr[Idx] = arr[startLeft++];
			}
			Idx++;
		}
		
		if(startLeft>mid) {
			for(int i=startRight; i<=right;i++)
				newarr[Idx++] = arr[i];
		}else {
			for(int i=startLeft; i<=mid;i++)
				newarr[Idx++] = arr[i];
		}
		for(int i= left; i<=right;i++)
			arr[i] = newarr[i];
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if(left<=right) {
			int pivot = getParttion(arr,left,right);
			quickSort(arr,left,pivot-1);
			quickSort(arr,pivot+1,right);
		}
	}

	private static int getParttion(int[] arr, int left, int right) {
		int pivotValue = arr[left];
		int low = left;
		int high = right;
		
		while(low<=high) {
			while(low <= right && pivotValue >= arr[low])
				low++; //정렬되어있으면 low는 right+1까지감
			while(high >= (left+1) && pivotValue <= arr[high])
				high--; //정렬 되어있으면 high의 마지막 종착역은 pivot (left)
			
			if(low<=high) {
				swap(arr,low,high);
			}
		}
		swap(arr,left,high);
		
		return high;
	}
	private static void swap(int[] arr,int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}
