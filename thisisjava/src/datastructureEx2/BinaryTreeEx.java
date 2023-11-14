package datastructureEx2;

public class BinaryTreeEx {
	
	node root;
	
	public void insertValue(int value) {
		root = addRecursive(root,value);
	}
	
	public void deleteValue(int value) {
		root = deleteValueRecursive(root,value); //한 3개만 있다고 생각하고..
	}
	
	
	
	
	private node deleteValueRecursive(node cur, int value) {
		if(cur == null)
			return null; // 기준에 아무 값도 없으면 그냥 재귀호출 종료
		
		if(cur.value == value) {//해당노드 삭제해야함
			if(cur.left == null && cur.right ==null) {
				return null; //자식이 없으면 null리턴해서 노드 자체 없앰 
			}
			if(cur.right == null) { //오른쪽이 없으면, 오른쪽 리턴
				return cur.left;
			}
			if(cur.left == null) {//왼쪽이 없으면 오른쪽 리턴  
				return cur.right;
			}
			int minValue = findMinValue(cur.right); //minvalue는 왼쪽보단 크면서 오른쪽보단 작아야함
			cur.value = minValue;
			cur.right = deleteValueRecursive(cur.right,minValue);
			
		}
		
		if(value < cur.value) { //여기로 들어오면 root의 왼쪽이나 오른쪽 자식 설정하고 원본은 돌려줘야함
		 cur.left = deleteValueRecursive(cur.left, value);
		 return cur;
		}	
		cur.right = deleteValueRecursive(cur.right, value); //검사할 노드와 리턴값 
	
		
		return cur; // 왼쪽,오른쪽 검사식에 걸렸거나, 뭐 할게 없으면 다시 원위치 return 나머지는 변화 없게 만드는..
		            // 찾는 벨류가 root에 자식의 자식이거나 그러면 거기서 처리하게하고 root는 다시 반납해야함
	}

	private int findMinValue(node node) { //root중심 가장 왼쪽에 값을 찾음
		int minValue = (node.left == null)? node.value:findMinValue(node.left);
		return minValue;
	}

	private node addRecursive(node cur, int value) {
		if(cur == null)
			return new node(value);
		
		
		if(value < cur.value) {
			cur.left = addRecursive(cur.left,value);
		}
		else if(value > cur.value) {
			cur.right = addRecursive(cur.right,value);
		}else {
			
			return cur;
		}
		
		return cur; //자바에는 free같은 기능 없음!! root부터 시작하자 
		            // cur.left나 right에 걸렸으면 재귀호출 -> 제어넘김 -> 왼+오 설정하고 원래 root에는 다시 root들어감
	}



















	static class node{
		int value;
		node left;
		node right;
		public node(int v) {
			this.value = v;
		}
	}
}
