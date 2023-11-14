package searchTree;

import java.util.Comparator;

public class SearchTreeEx<T> {
	private node<T> root;
	private int num;
	private Tree<T> tree;
	private Comparator<T> com;
	
	public SearchTreeEx(Comparator<T> com) {
		root = null;
		num = 0;
		tree = new Tree<>();
		this.com = com;
	}
	
	public void insertData (T data) {
		node<T> dataParent = null;
		node<T> startNode = root;
		node<T> newDataNode = null;
		//노드 자리 찾기 
		while(startNode != null) {
			dataParent = startNode;
			
			if(com.compare(startNode.getData(), data) >0) {
				startNode = startNode.getleft();
			}else
				startNode = startNode.getRight();
		}
		
		newDataNode = tree.makeNewNode();
		newDataNode.setData(data);
		if(dataParent != null) {
			if(com.compare(dataParent.getData(), data)>0) {
				dataParent.setLeft(newDataNode);
			}else
				dataParent.setRight(newDataNode);
			
		}else {
			root = newDataNode;
		}
		
	}
	public node<T> findData (T data){
		node<T> cur = root;
		while(cur != null) {
			if(com.compare(cur.getData(), data) == 0) {
				return cur;
			}else {
				if(com.compare(cur.getData(), data) > 0) {
					cur = cur.getleft();
				}else 
					cur = cur.getRight();
			}
		}
		return null;
	}
	
	public node<T> deleteData(T data){
		node<T> vRoot = tree.makeNewNode();
		node<T> delParent = vRoot;
		node<T> startNode = root;
		node<T> delNode = null;
		tree.setRightNode(vRoot, root);
		T rootData = root.getData();
		//일단 찾기 
		while(startNode != null && com.compare(startNode.getData(), data) != 0) {
			delParent = startNode;
			if(com.compare(startNode.getData(), data) > 0)
				startNode = startNode.getleft();
			else 
				startNode = startNode.getRight();
		}
		if(startNode == null) return null; // 삭제할 노드 찾지 못함
		
		delNode = startNode;
		
		//스텝 1 삭제할 노드에 자식이 없음 
		if(delNode.getleft() == null && delNode.getRight() ==null) {
			if(delParent.getleft() == delNode) {
				tree.removeLeftSubTree(delParent);
			}else
				tree.removeRightSubTree(delParent);
		}else if(delNode.getleft() == null || delNode.getRight() == null) {
			node<T> child;
			if(delNode.getleft() == null)
				child = delNode.getRight();
			else 
				child = delNode.getleft();
			
			if(delParent.getleft() == delNode) {
				tree.ChangeLeftSubTree(delParent, child);
			}else
				tree.ChangeRightSubTree(delParent, child);
		}else {
			//스텝 3 두개의 자식이 있을 때 오른쪽에서 가장 작은 값 가져와서 교체 
			node<T> modifyNode = delNode.getRight();
			node<T> modiParent = delNode;
			while(modifyNode != null) {
				modiParent = modifyNode;
				modifyNode = modifyNode.getleft();
			}
			//삭제할 노드 값을 대체 
			T delData = delNode.getData();
			tree.setData(delNode, modifyNode.getData());
			
			//삭제노드의 오른쪽 노드를 삭제노드 부모에 연결
			if(modiParent.getleft() == modifyNode) {
				tree.ChangeLeftSubTree(modiParent,modifyNode.getRight());
			}else
				tree.ChangeRightSubTree(modiParent, modifyNode.getRight()); //오른쪽 연결은 삭제할 노드가 바로 오른쪽일때만 작동할 듯 
			
			delNode = modifyNode;
			tree.setData(modifyNode, delData);
		}
		if(vRoot.getRight().getData() != rootData) {
			root = vRoot.getRight();
		}
		vRoot = null;
		return delNode;
	}
	
}
