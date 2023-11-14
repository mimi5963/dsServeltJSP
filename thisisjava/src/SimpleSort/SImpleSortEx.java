package SimpleSort;

public class SImpleSortEx {

	
	public void bubleSort(int[] arr) {
		for(int i=0; i<arr.length-1;i++) {
			for(int j=0;i<arr.length-i-1;j++) {
				if(arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public void SelectSort(int[] arr) {
		int maxIdx;
		for(int i=0; i<arr.length-1;i++) {
			maxIdx = i;
			for(int j=i+1; j<arr.length;j++) {
				if(arr[maxIdx] < arr[j]) 
					maxIdx = j;
			}
			int temp = arr[maxIdx];
			arr[maxIdx] = arr[i];
			arr[i] = temp;
		}
	}
	public void insertSort(int[] arr) {
		int i,j;
		int target;
		for(i=1; i<arr.length;i++) {
			target = arr[i];
			for(j = i-1; j>=0; j--) {
				if(arr[j] <target) { //target의 첫 시장은 j+1;
					arr[j+1] = arr[j];
				}else break;
			}
			arr[j+1] = target;
		}
	}
}
