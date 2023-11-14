package searchTree;

import java.util.Comparator;

public class SearchTreeEx2<T> {

	private node<T> root;
	private Comparator<T> com;
	private int size;
	private Tree<T> tree;
	
	public SearchTreeEx2(Comparator<T> com) {
		this.com = com;
		size = 0;
		root = null;
		tree = new Tree<>();
	}
	
	public void BSTinsert(T data) {
		node<T> start = root;
		node<T> dataParent = null;
		
		while(start != null) {
			dataParent = start;
			
			if(com.compare(start.getData(), data) >0)
				start = start.getleft();
			else 
				start = start.getRight();
		}
		
		node<T> newNode = tree.makeNewNode();
		newNode.setData(data);
		
		if(dataParent != null) {
			
			if(com.compare(dataParent.getData(), data) > 0)
				dataParent.setLeft(newNode);
			else 
				dataParent.setRight(newNode);
			
		}else root = newNode;
	}
	
	public node<T> findNode(T data){
		node<T> start = root;
		
		while(start != null) {
			if(com.compare(start.getData(), data) == 0)
				return start;
			else {
				if(com.compare(start.getData(), data) > 0)
					start = start.getleft();
				else start = start.getRight();
			}
		}
		
		return null;
		
	}
	
	public node<T> delete(T data) {
		node<T> rootParent = tree.makeNewNode(); //마지막 체크용
		
		node<T> dataParent = rootParent; //찾기 용도 
		node<T> start = root;
		node<T> delNode;
		rootParent.setRight(root); // root변경시 검사용도
		T originRootData = root.getData();
		//삭제할 데이터 찾기 
		while(start != null && com.compare(start.getData(), data) != 0) {
			dataParent = start;
			
			if(com.compare(start.getData(), data) > 0)
				start = start.getleft();
			else 
				start = start.getRight();
		}
		if(start == null) return null;
		
		delNode = start;
		
		//case 1 자식 없음 (삭제할 노드)
		if(delNode.getleft() == null && delNode.getRight() == null) {
			if(dataParent.getleft() == delNode) {
				dataParent.setLeft(null);
			}else 
				dataParent.setRight(null);
		}
		//case 2 자식 하나 임
		else if(delNode.getleft() == null || delNode.getRight() == null) {
			node<T> child;
			
			if(delNode.getleft() != null)
				child = delNode.getleft();
			else 
				child = delNode.getRight();
			
			if(dataParent.getleft() == delNode) {
				dataParent.setLeft(child);
			}else 
				dataParent.setRight(child);
		}
		
		//case 3 자식이 둘다 있을 때 -> 삭제할 노드 오른쪽에서 가장 작인 애 
		else {
			node<T> modify = delNode.getRight();
			node<T> modifyParent =delNode;
			
			//대체 노드 찾기
			while(modify.getleft() != null) {
				modifyParent = modify;
				modify = modify.getleft();
			}
			
			T delData = delNode.getData();
			delNode.setData(modify.getData()); // 대체 노드의 값을 삭제할 노드에 넣기 
			
			//무조건 left일것 같지만.. 만약 바로 오른쪽 자식이 left가 없을 수도 있음 
			if(modifyParent.getleft() == modify) {
				modifyParent.setLeft(modify.getRight());
			}else 
				modifyParent.setRight(modify.getRight());
			
			//맨 마지막 노드에 삭제할 값 넣고, 삭제 대상으로 지정 
			modify.setData(delData);
			delNode = modify;
		}
		
		if(rootParent.getRight() != root || com.compare(rootParent.getRight().getData(), originRootData)!=0) //자식이 하나인 경우 바뀔 수 있지
		{
			root = rootParent.getRight();
		}
		return delNode;
	}
	public void printAll() {
		tree.preOrderTraverse(root, c -> System.out.println(c.getData()));
	}
}
