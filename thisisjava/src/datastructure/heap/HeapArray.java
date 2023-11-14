package datastructure.heap;

public class HeapArray<T> {
	int numOfdata;
	HeapElem[] heapArr;
	
	public HeapArray(){
		this.numOfdata=0;
		heapArr = new HeapElem[100];
	}
	
	public boolean HisEmpty() {
		if(numOfdata == 0)
			return true;
		return false;
	}
	public void HInsert(T data, int pr){
		int idx = this.numOfdata+1; //새로운 데이터는 일단 해당 가장 마지막 인덱스 부여 (배열기반이라 pr기준으로 인덱싱 한거라 인덱스 순서 -> pr순서임)
		HeapElem nelem = new HeapElem(data,pr); //실제 pr과 data를 이용해 엘리먼트 만듦
		while( idx != 1) { //idx 1이아님 루트임 여기는 처음에만 초기화 
			//지금 맨 마지막 idx값 부여받았는데 -> pr을 통해 자기자리 찾아가는 것 
			if(nelem.compareTo(heapArr[GetParentIDX(idx)]) < 0) { //지 부모보다 우선순위 높은 경우 
				heapArr[idx] = heapArr[GetParentIDX(idx)]; //부모랑 자식 자리 바꿈
				idx = GetParentIDX(idx);//부모의 idx 부여받음 
			}else break;
		}
		heapArr[idx] = nelem; //부모보다 우선순위 낮다고 판명난 경우 혹은 idx == 1이됨 pr에 맞게 idx에 저장
		this.numOfdata +=1;
		
	}
	public T HDelete() {
		//우선순위 큐에서 삭제는 가장 우선순위 높은 1번 인덱스를 지우는 것 루트 지우기임
		T delete  =(T) heapArr[1].data;
		HeapElem<T> lastElem = heapArr[numOfdata];
		
		int startIdx =1;
		int childIdx;
		
		while(true) {
			childIdx = GetHipriChildIDX(startIdx);
			if(lastElem.compareTo(heapArr[childIdx]) <= 0)break;
			
			heapArr[startIdx] = heapArr[childIdx];
			startIdx = childIdx;
		}
		heapArr[startIdx] = lastElem;
		this.numOfdata -= 1;
		
		
		return delete;
	}
	
	private int GetParentIDX(int idx) {
		return idx/2;
	}
	
	private int GetLeftChild(int idx) {
		return idx*2;
	}
	private int GetRightChild(int idx) {
		return GetLeftChild(idx)+1;
	}
	//두개의 자식노드중 높은 우선순우의 자식 노드 인덱스 값 반환 
	private int GetHipriChildIDX(int idx) {
		if(GetLeftChild(idx) > this.numOfdata) //자식없음
			return 0;
		else if(GetLeftChild(idx) == this.numOfdata){
			return GetLeftChild(idx); //왼쪽 자식 뿐임
		}
		else {
				//우선순위 검사하는데 지금 pr이 작을 수록 우선순위 높음
			   if(heapArr[GetLeftChild(idx)].compareTo(heapArr[GetRightChild(idx)]) > 0 )
				   return GetRightChild(idx);
			   else
				   return GetLeftChild(idx);
			}	
		}
	
	
	
}
