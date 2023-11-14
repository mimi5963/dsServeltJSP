package serch;

public class Simple {

	public static void main(String[] args) {
			int[] arr = {1,2,3,4,5,6,7,8,9,10};
			int val = binerySearch(arr,0,arr.length-1,3);
			System.out.println(val);
			item[] item = new item[10];
			for(int i=0; i< 10 ; i++) {
				item[i] = new item(i+1,+i+"사원");
			}
			int idx = ISearch(item,0,item.length-1,0);
			System.out.println(idx);
	}
	
	public static int binerySearch(int[] arr,int first, int last,int findval) {
		
		
		if(first > last) return -1;
		
		int mid = (first+last)/2;
		
		if(arr[mid] == findval) 
			return mid;
		else if(arr[mid] < findval) {
			return binerySearch(arr,mid+1,last,findval);
		}else {
			return binerySearch(arr,first,mid-1,findval);
		}
		
		
		
		
	}
	
	public static int ISearch(item arr[], int first, int last, int target) {
		int mid;
		
		if(arr[first].key > target || target>arr[last].key) 
			return -1;
		
		mid = (int)((double)(target-arr[first].key)/(arr[last].key-arr[first].key)*(last-first))+first;
		
		if(arr[mid].key == target)
			return mid;
		else if(target < arr[mid].key)
			return ISearch(arr,first,mid-1,target);
		else 
			return ISearch(arr,mid+1,last,target);
	}
	
}

class item{
	int key;
	String data;
	public item(int key, String data ) {
		this.key = key;
		this.data =data;
	}
}
