package searchTree;

import java.util.Comparator;

public class SearchTree<T> {
	node<T> root;
	Comparator<T> com;
	int size;
	Tree<T> tree;
	SearchTree(Comparator<T> com){
		this.com = com;
		this.root = null;
		size = 0;
		this.tree = new Tree<T>();
	}
	
	public void BSTGetNodeData() {
		
	}
	public void BSTInsert(T data) {
		node<T> newDataParent = null;
		node<T> startNode = root; // 탐색용
		node<T> newNode = null;
		
		while(startNode != null) { //자리 찾기 null자리에 들어갈 것
			newDataParent = startNode;
			
			if(com.compare(startNode.getData(),data)>0) {
				startNode = startNode.getleft();
			}else
				startNode = startNode.getRight();
		}
		//새로 넣을 newNode의 부모를 찾음 
		newNode = Tree.makeNewNode();
		newNode.setData(data);
		if(newDataParent != null) {
		if(com.compare(newDataParent.getData(), data) > 0) {
			tree.setLeftNode(newDataParent, newNode);
		}else {  
			tree.setRightNode(newDataParent, newNode);
		
		}
		}else root = newNode;
	}
	public node<T> BSTSearch(T target){
		node<T> startNode = root;
		T startData;
		
		while(startNode != null) {
			startData = tree.getData(startNode);
			
			if(startData == target) {
				return startNode;
			}else {
				if(com.compare(target, startData) > 0)
					startNode = tree.getRight(startNode);
				else startNode = tree.getLeft(startNode);
			} 
		}
		return null;
		
	}
	
	public node<T> BSTDelets(T data){
		node<T> tempRoot = tree.makeNewNode(); // 가사 root
		node<T> delDataParent = tempRoot; //시작을 가상 루트
		node<T> startNode = root; // 시작은 루트 
		node<T> delNode= null;//삭제할 노드 
		
		tree.setRightNode(tempRoot, root); //가상에 오른쪽에 root 가정 
		
		//찾는과정
		while(startNode != null && com.compare(startNode.getData(), data) != 0) {
			delDataParent = startNode;
			if(com.compare(startNode.getData(), data) >0) {
				startNode = tree.getLeft(startNode);
			}else {
				startNode = tree.getRight(startNode);
			}
		}
		if(startNode == null) return null; // 삭제 대상 없음
		
		delNode = startNode;
		
		//1번 케이스 단말노드
		if(delNode.getleft() == null && delNode.getRight() == null) {
			if(delDataParent.getleft() == delNode) {
				tree.removeLeftSubTree(delDataParent);
			}else {
				tree.removeRightSubTree(delDataParent);
			}
		}
		
		//2번 케이스 삭제 대상이 하나의 자식 가지는 경우 
		else if(delNode.getleft() == null || delNode.getRight() == null ) {
			node<T> child;
			if(delNode.getleft() == null) {
				child = delNode.getRight();
			}else
				child = delNode.getleft();
			//오른쪽 왼쪽 중 살아있는 자식 구하고
			
			//삭제 노드가 부모에 왼쪽 or 오른쪽인지 검사해서 붙이기
			if(delDataParent.getleft() == delNode) {
				tree.ChangeLeftSubTree(delDataParent, child);
			}else
				tree.ChangeRightSubTree(delDataParent, child);
		}
		
		//케이스 3 자식이 두개있으면 (오른쪽에서 가장 작은 값으로 삭제노드 대체, 대체된 노드의 오른쪽 자식을 붙이기)
		else {
			
			node<T> changeNode = delNode.getRight();
			node<T> changeNodeParent = delNode;
			T delData;
			
			//대체노드 찾기 
			while(changeNode.getleft() != null) {
				changeNodeParent = changeNode;
				changeNode = changeNode.getleft();
			}
			
			//대체 노드 값을 삭제 노드에 대입 
			delData = delNode.getData();
			delNode.setData(changeNode.getData());
			
			//대체 노드 부모랑 자식 연결 
			if(changeNodeParent.getleft() == changeNode) {
				tree.ChangeLeftSubTree(changeNodeParent, changeNode.getRight());
			}else
				tree.ChangeRightSubTree(changeNodeParent, changeNode.getRight());
			
			//이제 삭제 대상은 마지막 노드이고 원래 삭제하려던 값 가지고 있도록 설정
			delNode = changeNode;
			changeNode.setData(delData);
		}
		
		//루트 노드면 루트노드의 부모에 오른쪽 왼쪽 여기에 새로운 노드 연결함!!! 맞아
		if(tempRoot.getRight() != root) {
			root = tempRoot.getRight();
		}
		tempRoot = null;
		
		return delNode;
	}
}
