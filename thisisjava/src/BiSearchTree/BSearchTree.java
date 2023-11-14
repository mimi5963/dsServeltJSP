package BiSearchTree;

import java.util.Comparator;

public class BSearchTree<T> {
	BineryTree<T> bitree;
	private BNode<T> root;
	Comparator<T> c = (a,b) ->{
		return (Integer)a - (Integer)b;
	}; 
	public BSearchTree() {
			bitree = new BineryTree<>();
			root =null;
	}
	
	
	T BSTGetNodeData(BNode<T> nod) {
		return null;
	}
	public void BSTInsert(T data) {
		BNode<T> parentN = null;
		BNode<T> curNode = root;
		BNode<T> newNode = null;
		
		//새로운 노드가 추가될 위치를 찾는다.
		while(curNode != null) {
			if(data == bitree.getData(curNode))
				return; // 중복 허용 안함
			parentN = curNode; //루트부터 시작해서 쭉 내려감
			if(c.compare(bitree.getData(curNode), data) > 0) {
				curNode = bitree.getLeftSubTree(curNode);
			}else
				curNode = bitree.getRightSubTree(curNode);
			
		}//cur이 null이되면 그자리가 넣을 자리고, 그것보다 한칸 위가 부모 
		
		// parent에 자식 노드로 추가할 새 노드 생성
		newNode = bitree.makeNode();
		newNode.data =data;
		
		if(parentN != null) {
			
			if(c.compare(data, bitree.getData(parentN)) <0) {
				bitree.setLeftSubTree(parentN, newNode);
			}else {
				bitree.setRightSubTree(parentN, newNode);
			}
		}else {
			root = newNode; //부모가 null인 경우는 root뿐
		}
	}
	public BNode<T> BSTSearch(T target){
		BNode<T> cnode = root;
		T cd;
		while(cnode != null) {
			cd = bitree.getData(cnode);
			
			if(c.compare(target, cd) == 0)
				return cnode;
			else if(c.compare(target, cd) > 0)
				cnode = bitree.getRightSubTree(cnode);
			else 
				cnode = bitree.getLeftSubTree(cnode);
		}
		
		return null; //탐색대상이 저장된게 없음
	}
	
	BNode<T> BSTRemove(T target){
		BNode<T> pvRoot = bitree.makeNode();
		BNode<T> pNode = pvRoot;
		BNode<T> cNode = root;
		BNode<T> dNode;
		
		bitree.ChangeRightSubTree(pvRoot, root); //처음에 설정해놨구나
		
		while(cNode != null && bitree.getData(cNode) != target) {
			
			pNode = cNode; //값 찾지 못해서 부모노드 현재노드로 설정하고 자식으로 내려갈 것
			
			if(c.compare(target, bitree.getData(cNode)) < 0)
				cNode = bitree.getLeftSubTree(cNode);
			else 
				cNode = bitree.getRightSubTree(cNode);
		}
		if(cNode == null)
			return null;
		
		dNode = cNode;
		
		//첫번째 경우 : 삭제 대상이 단말노드
		if(bitree.getLeftSubTree(dNode) == null && bitree.getRightSubTree(dNode) == null ) {
			if(bitree.getLeftSubTree(pNode) == dNode) {
				bitree.RemoveLeftSubTree(dNode);
				
			}else
				bitree.RemoveRightSubTree(dNode);
		}else if(bitree.getLeftSubTree(dNode) == null || bitree.getRightSubTree(dNode) ==null) {
			BNode<T> dcNode; // 삭제 대상의 자식
			
			if(bitree.getLeftSubTree(dNode) != null) {
				dcNode = bitree.getLeftSubTree(dNode);
			}else
				dcNode = bitree.getRightSubTree(dNode);
			
			if(bitree.getLeftSubTree(pNode) == dNode)
				bitree.ChangeLeftSubTree(pNode, dcNode);
			else 
				bitree.ChangeRightSubTree(pNode, dcNode);
		}
		else {
			
			BNode<T> mNode = bitree.getRightSubTree(dNode); // 대체 노드
			BNode<T> mpNode = dNode; //대체 노드의 부모
			T deldata;
			while(bitree.getLeftSubTree(mNode) != null) {
				mpNode = mNode;
				mNode = bitree.getLeftSubTree(mNode);
			}
			
			deldata = bitree.getData(dNode); //대입전 백업
			bitree.setData(dNode, bitree.getData(mNode));//대입
			
			//대체 노드의 부모와 자식노드 연결
			if(bitree.getLeftSubTree(mpNode) == mNode)
				bitree.ChangeLeftSubTree(mpNode, bitree.getRightSubTree(mNode));
			else 
				bitree.ChangeRightSubTree(mpNode, bitree.getRightSubTree(mNode));
			
			dNode = mNode;
			bitree.setData(dNode, deldata);
		}
		
		//삭제노드가 루트인 경우 추가처리
		if(bitree.getRightSubTree(pvRoot) != root) {
			root = bitree.getRightSubTree(pvRoot);
		} //3번케이스 말고.. 2번 케이스에서 변경될 수 있는듯 1번이나 
		
		return dNode;
	}
	BNode<T> remove2(T target){
		BNode<T> root2 = bitree.makeNode();
		BNode<T> proot = root2; //가상 맨 위 노드
		BNode<T> cNode = root; //시작노드 (루트부터)
		BNode<T> dNode; //삭제할 노드
		
		//일단 탐색
		while(cNode != null && bitree.getData(cNode) != target ) {
			proot = cNode; //초기에 루트대입 (부모 계속 저장됨)
			
			if(c.compare(target, bitree.getData(cNode)) < 0 ) // 노드 데이터가 더큼
				cNode = bitree.getLeftSubTree(cNode);
			else cNode = bitree.getRightSubTree(cNode); //현재 노드에서 자식으로 내려감
		}
		if(cNode == null) //삭제대상 존재안함
			return null;
		
		dNode = cNode; //탐색완료 cNode이제 필요없음 -> dNode와 부모만 검사
		
		//1번케이스 dNode의 자식 없음
		if(bitree.getLeftSubTree(dNode)==null && bitree.getRightSubTree(dNode) ==null) {
			if(bitree.getLeftSubTree(proot) == dNode) { //삭제할 노드가 부모의 왼쪽
				bitree.RemoveLeftSubTree(proot); // 부모의 왼쪽 자름
			}else
				bitree.RemoveRightSubTree(proot);
		}
		
		
		//2번 케이스 자식이 하나 있음 -> 부모랑 자식만 연결
		else if(bitree.getLeftSubTree(dNode)==null || bitree.getRightSubTree(dNode) == null) {
			
			BNode<T> delChild; // 삭제할 노드의 자식
			
			if(bitree.getLeftSubTree(dNode) != null)
				delChild = bitree.getLeftSubTree(dNode);
			else 
				delChild = bitree.getRightSubTree(dNode);
			
			if(bitree.getLeftSubTree(proot) == dNode)
				bitree.ChangeLeftSubTree(proot, delChild);
			else 
				bitree.ChangeRightSubTree(proot, delChild);
			
		}
		
		//3번 케이스 두개의 자식이 있을 경우 오른쪽에서 가장 작은 값 찾은 다음 맨 위에 대입 -> 남은 자식 연결
		else {
			BNode<T> miniRight = bitree.getRightSubTree(dNode);
			BNode<T> miniP = dNode; // 가장 작은 노드의 부모 -> 바뀔꺼임
			T del;
			while(bitree.getLeftSubTree(miniRight) != null) {
				miniP = miniRight;
				miniRight = bitree.getLeftSubTree(miniRight);
			}
			//대체 노드 값 찾았으면 대입
			del = bitree.getData(dNode);//삭제할 노드의 값 일단 백업
			bitree.setData(dNode, bitree.getData(miniRight)); //대입 제일작은 오른쪽 값을 삭제할 노드에 대입
			
			//대체 노드 부모랑 자식노드 연결 
			if(bitree.getLeftSubTree(miniP) == miniRight) {
				bitree.ChangeLeftSubTree(miniP, bitree.getRightSubTree(miniRight));
			}else 
				bitree.ChangeRightSubTree(miniP, bitree.getRightSubTree(miniRight)); //mini의 left가 남아있었으면 계속 내려갔을 것
		
			dNode = miniRight; //삭제할 노드 마지막 노드로 변경
			bitree.setData(dNode, del);  // 마지막 노드에 백업했던 값 넣어둠 (꼬리 자르기)
			
		}
		if(bitree.getRightSubTree(proot) != root)
			root = bitree.getRightSubTree(proot);
		
		proot = null;
		return dNode;
	}
}
