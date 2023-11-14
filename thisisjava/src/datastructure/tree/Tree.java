package datastructure.tree;

import java.nio.channels.NetworkChannel;
import java.util.function.Consumer;

public class Tree<T> {

	private node<T> root;
	
	public Tree(node t) {
		this.root = t;
	}
	public static <T> node<T> createnode(){
		return new node<T>();
	}
	
	public void dataInset(node<T> n, T data) {
		n.setData(data);
	}
	public T getData(node<T> n) {
		return n.getData();
	}
	public node<T> getLeft(node<T> n){
		return n.getLeft();
	}
	public node<T> getRight(node<T> n){
		return n.getRight();
	}
	
	public void setLeft(node<T> root, node<T> n) {
		root.setLeft(n);
	}
	public void setRight(node<T> root, node<T> n) {
		root.setRight(n);
	}
	
	public void inorderTraverse(node<T> root, Consumer<node<T>> c) {
		if(root == null)return;
		inorderTraverse(root.getLeft(),c);
		c.accept(root);
		inorderTraverse(root.getRight(),c);
		
	}
	
	public void preorderTraverse(node<T> root, Consumer<node<T>> c) {
		if(root == null) return;
		c.accept(root);
		preorderTraverse(root.getLeft(),c);
		preorderTraverse(root.getRight(),c);

	}
	public void postorderTraverse(node<T> root, Consumer<node<T>> c) {
		if(root==null) return;
		postorderTraverse(root,c);
		postorderTraverse(root,c);
		c.accept(root);
	}
	
	
	public void deleteNode(node<T> dnode) {
		root = findNodeAndDeleteFromRoot(root,dnode);
	}
	
	
	
	
	private node<T> findNodeAndDeleteFromRoot(node<T> cur, node<T> dnode) {
		if(cur == null) {
			return null;
		}
		
		Consumer<node<T>> c = (n) ->{
			n.setLeft(null);
			n.setRight(null);;
			
		}; 
	
		if(cur == dnode) {
			postorderTraverse(cur,c);
			return null;
		}else {
		cur.left=findNodeAndDeleteFromRoot(root.getLeft(),dnode);
		cur.right=findNodeAndDeleteFromRoot(root.getRight(),dnode);
		}
		
		
		return cur;
	}



	static class node<T>{
		private T data;
		private node<T> left;
		private node<T> right;
		
		public void setData(T data) {
			this.data = data;
		}
		public void setLeft(node<T> t) {
			this.left = t;
		}
		public void setRight(node<T> t) {
			this.right = t;
		}
		public T getData() {
			return this.data;
		}
		public node<T> getLeft(){
			return this.left;
		}
		public node<T> getRight(){
			return this.right;
		}
	}
	
	
}
