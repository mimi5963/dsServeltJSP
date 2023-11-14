package datastructureEx2;

public class BinaryTree {
	
	Node root;
	
	public void add (int value) {
		root = addRecursive(root,value);
	}
	
	public boolean containsNode(int value) {
	 return containsNodeRecursive(root,value);
	}
	
	public void deleteNode(int value) {
		root = deleteRecursive(root,value);
	}

	private Node deleteRecursive(Node cur, int value) {
		if(cur == null) {
			return null;
		}
		if(value == cur.value) {
			if(cur.left == null && cur.right == null)
				return null;
			if(cur.right == null) {
				return cur.left;
			}
			if(cur.left == null) {
				return cur.right;
			}
			int smallestValue = findSmallestValue(cur.right); //원래 루트보단 큰 값 중 가장 작은값
			cur.value = smallestValue;
			cur.right = deleteRecursive(cur.right,smallestValue);
			return cur;
		}
		if(value < cur.value) {
			cur.left = deleteRecursive(cur.left,value);
			return cur;
		}
		cur.right = deleteRecursive(cur.right,value);
		return cur;
	}

	private int findSmallestValue(Node cur) {
		
		return cur.left == null ? cur.value : findSmallestValue(cur.left); //root의 왼쪽만 탐색 (가장 작은 값)
	}

	private boolean containsNodeRecursive(Node cur, int value) {
		if(cur == null) {
			return false;
		}
		if(value == cur.value)
		return true;
		//preorderTraverse + 정렬
		return value < cur.value ? 
				containsNodeRecursive(cur.left,value) 
				: containsNodeRecursive(cur.right,value);
	}

	private Node addRecursive(Node cur, int value) {
		if(cur == null)
		return new Node(value);
		//value가 현재 값보다 작으면 왼쪽 크면 오른쪽 
		if(value<cur.value) {
			cur.left = addRecursive(cur.left,value);
			//node를 return하는 이유는 연결된 노드가 없고 새로 만들어야할 때 넣으려고
		}else if( value > cur.value) {
			cur.right = addRecursive(cur.right,value);
		}else {
			//value alredy exists
			return cur;
		}
		
		return cur;
	}







	static class Node{
		int value;
		Node left;
		Node right;
		
		Node(int value){
			this.value = value;
			right = null;
			left = null;
		}
		public int getData() {
			return this.value;
		}
	}
	
	
}
