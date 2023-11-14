package SimpleSort;

import java.util.Arrays;

public class SimpleSortTest {

	public static void main(String[] args) {
		int[] arr = {3,2,4,1,3,6,5,7,8,3,2,4,2,5,6,7,3,9,10,22};
		divide(arr,0,arr.length-1);
		System.out.println("divide: "+Arrays.toString(arr));
		mergeSort(arr,0,arr.length-1);
		System.out.println("merge: "+Arrays.toString(arr));
		InsertionSort(arr);
		System.out.println(Arrays.toString(arr));
		bubleSort(arr);
		System.out.println(Arrays.toString(arr));
		SelectionSort(arr);
		System.out.println(Arrays.toString(arr));
		int[] arr2 = {1,3,5,2};
		InsertionSort(arr2);
		System.out.println(Arrays.toString(arr2));
		InsertionSort(arr);
		
	}
	
	public static void bubleSort(int[] arr) {
		for(int i=0 ; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void SelectionSort(int[] arr) {
		for(int i=0; i<arr.length-1;i++) {
			int Maxvalueidx = i;
			for(int j=i+1; j<arr.length;j++) {
				if(arr[Maxvalueidx] < arr[j]) {
					Maxvalueidx = j;
				}
			}
			
			int temp = arr[Maxvalueidx];
			arr[Maxvalueidx] = arr[i];
			arr[i] = temp;
			
		}
	}
	
	public static void InsertionSort(int[] arr) {
		//1,3,5,2
		
		for(int i=0; i<arr.length-1;) {
			int j;
			if(arr[i] < arr[i+1]) {
				i++;
			}
			else {
				for( j=i+1; j>0;j--) {
					if(arr[j] < arr[j-1]) {
						int temp = arr[j];
						arr[j] = arr[j-1];
						arr[j-1] = temp;
					}
				}
				i+=j;
			}
		}
		}
	
	public static void InserSort(int[] arr) {
		int i,j;
		int insData;
		
		for(i=1; i<arr.length;i++) {
			
			insData = arr[i];
			
			for(j=i-1; j>=0;j--) { //i보다 한칸 뒤부터 검사 0까지
				if(arr[j] >insData) {
					arr[j+1] = arr[j]; //삽입하려는 데이터보다 크면 한칸 뒤 +1로 밀기 
				}else break;
			}
			arr[j+1] = insData; //마지막 j에 한칸 뒤가 위차할 자리
		}
	}
		
	public static void mergeSort(int[] arr, int left, int right) {
	int mid;
	
	if(left<right) {
		mid = (left+right)/2; 
		
		mergeSort(arr,left,mid); 
		mergeSort(arr,mid+1,right);
		mergeTwoArea(arr,left,mid,right); //3,4,1,2 mid ==4 
		
	}
		
	}

	private static void mergeTwoArea(int[] arr, int endLeft, int mid, int endRight) {
		//정렬해야할 두 그룹은 그룹간에는 이미 정렬된 상태로 들어옴
		
		int startLeft = endLeft; 
		int startRight = mid+1;
		int i;
		
		int[] sortarr = new int[endRight+1]; //빈배열
		int newarrayIdx = endLeft;
		
		while(startLeft <= mid && startRight <= endRight) {
			if(arr[startLeft] > arr[startRight]) { //mid중심으로 왼쪽 오른쪽 나누고 비교
				sortarr[newarrayIdx] = arr[startLeft++]; // 빈배열에 집어넣고 왼쪽 ++;
			}else {
				sortarr[newarrayIdx] = arr[startRight++]; // 빈배열에 오른쪽 집어넣고 ++;
			}
			newarrayIdx++;
		}
		
		if(startLeft>mid) { //왼쪽만 정렬되고 끝났을 때 나머지 넣기
			for(i=startRight;i<=endRight;i++,newarrayIdx++) {
				sortarr[newarrayIdx] = arr[i];
			}
		}else { //오른쪽만 정렬되고 끝났을 떄 나머지 넣기
			for(i=startLeft;i<=mid;i++,newarrayIdx++) {
				sortarr[newarrayIdx] = arr[i];
			}
		}
		for(i=endLeft;i<=endRight;i++) {
			arr[i] = sortarr[i];
		}
		sortarr=null;
	}
	
	public static void divide(int[] arr, int left, int right) {
		int mid;
		if(left<right) {
			mid = (left+right)/2;
			divide(arr,left,mid);
			divide(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int startLeft = left;
		int startRight = mid+1;
		int idx = left;
		int[] sortArr = new int[right+1];
		//2개남았을때 0 0 1이라도 0과 1을 비교해야함 따라서 startLeft는 mid까지
		//0 0 1일경우 startRight 1 end Right도 1임 따라서 끝까지가야함
		while(startLeft<=mid && startRight<=right) {
			if(arr[startLeft] < arr[startRight]) { 
				sortArr[idx] = arr[startRight++];
			}else {
				sortArr[idx] = arr[startLeft++]; //<=startRight
			}
			idx++;
		}
		
		if(startLeft>mid) {
			for(int i=startRight;i<=right;i++,idx++) {
				sortArr[idx] = arr[i];
			}
		}
		else{
			for(int i=startLeft;i<=mid;i++,idx++) {
				sortArr[idx] = arr[i];
			}
		}
		for(int i=left; i<=right;i++) {
			arr[i] = sortArr[i];
		}
	}
		
	public static int partition(int[] arr,int left,int right) {
		int pivot = left;
		int low = left+1;
		int high = right;
		
		while(low<=high) {
			while(arr[pivot] >= arr[low] && low<=right)
					low++;
			while(arr[pivot] <= arr[high] && high>=(left+1))
				   high--;
			if(low<=high) {
				swap(arr,low,high);
			}
		}
		swap(arr,left,high); //피벗과 high교환
		return high; //옮겨진 피벗 위치 반환
	}
	public static void quickSort(int[] arr, int left, int right) {
		if(left<=right) {
			int mid = partition(arr,left,right);
			quickSort(arr,left,mid-1);
			quickSort(arr,mid+1,right);
		}
	}
	public static void swap(int[] arr,int idx1,int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
		
	}

