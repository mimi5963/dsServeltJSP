package TreeAndHeap;

import java.util.function.Consumer;

public class Tree<T> {

	private Node<T> root;
	int numOfdata;
	public Tree() {
		numOfdata =0;
		root = new Node<T>();
	}
	public Node<T> getRoot(){
		return root;
	}
	public static <T> Node<T> makeNode(){
		return new Node<T>();
	}
	
	public void makeLeftNode(Node<T> cur,Node<T> node) {
		cur.left = node;
	}
	public void makeRightNode(Node<T> cur, Node<T> node){
		cur.right = node;
	}
	public Node<T> getLeftNode(Node<T> cur){
		return cur.left;
	}
	public Node<T> getRightNode(Node<T> cur){
		return cur.right;
	}
	public void setData(Node<T> cur, T data) {
		cur.data =data;
	}
	
	public void inorderTraverse(Node<T> cur, Consumer<Node<T>> c) {
		if(cur == null) return;
		
		inorderTraverse(cur.left,c);
		c.accept(cur);
		inorderTraverse(cur.right,c);
	}
	
	public void preorderTraverse(Node<T> cur, Consumer<Node<T>> c) {
		if(cur == null) return;
		c.accept(cur);
		preorderTraverse(cur.left,c);
		preorderTraverse(cur.right,c);
	}
	public void postorderTraverse(Node<T> cur, Consumer<Node<T>> c) {
		if(cur == null) return;
		postorderTraverse(cur.left,c);
		postorderTraverse(cur.right,c);
		c.accept(cur);
	}
	
	public void deleteNode(Node<T> node) {
		root = deleteNodeFromRoot(root,node);
	}
	
	
	
	
	private Node<T> deleteNodeFromRoot(Node<T> cur, Node<T> node) {
		if(cur == null) return null;
		
		Consumer<Node<T>> c = no -> {
			no.left = null;
			no.right =null;
		};
		
		if(cur == node) {
			postorderTraverse(cur,c);
			return null;
		}else {
			cur.left = deleteNodeFromRoot(cur.left,node);
			cur.right = deleteNodeFromRoot(cur.right,node);
		}
		
		
		
		
		
		return cur;
	}







	static class Node<T>{
		
		T data;
		Node<T> left;
		Node<T> right;
		
	}
}
