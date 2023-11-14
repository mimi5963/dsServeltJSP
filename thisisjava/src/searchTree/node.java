package searchTree;

public class node<T> {
	
	private T data; 
	private node<T> left;
	private node<T> right;
	public node(T data) {
		this.data=data;
		this.left = null;
		this.right = null;
		
	}
	
	public node<T> getleft(){
		return this.left;
	}
	public node<T> getRight(){
		return this.right;
	}
	public void setLeft(node<T> node) {
		this.left = node;
	}
	public void setRight(node<T> node) {
		this.right = node;
	}
	public T getData() {
		return this.data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
