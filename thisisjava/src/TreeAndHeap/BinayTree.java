package TreeAndHeap;

public class BinayTree {
    
	private Node root;
	int numOfdata;
	
	public BinayTree() {
		numOfdata =0;
	}
	
	public void insertData(int data) {
		root = addRecursive(root,data);
	}
	
	
	
	public void deleteData(int data) {
		root = deleteRecursive(root,data);
	}
	
	
	private Node deleteRecursive(Node cur, int data) {
		if(cur == null) return null;
		
		if(cur.data == data) {
			if(cur.left == null && cur.right == null)
				return null;
			
			if(cur.left == null)
				return cur.right;
			if(cur.right == null)
				return cur.left;
			
			int minNumofRightNode = findMindata(cur.right);
			cur.data = data;
			deleteRecursive(cur.right,data);
			this.numOfdata -=1;
		}
		
		if(data < cur.data) {
			cur.left = deleteRecursive(cur.left,data);
			return cur;
		}
		cur.right = deleteRecursive(cur.right,data);
		
		return cur;
	}

	private int findMindata(Node node) {
		int result = (node.left == null) ? node.data : findMindata(node.left);
		return result;
	}

	private Node addRecursive(Node cur, int data) {
		if(cur == null) return new Node(data); //데이터 없음
		
		if(cur.data == data) {
			return cur; //이미 데이터 있음
		}
		
		if(data < cur.data) {
		
			cur.left = addRecursive(cur.left,data);
		
		}else if(data>cur.data) {
			
			cur.right = addRecursive(cur.right,data);
		}
		
		
		return cur;
	}






	static class Node{
		public Node(int data) {
			this.data = data;
		}
		int data;
		Node left;
		Node right;
	}
}
