package datastructure.tree;

public class BtreeNode<T> {
	private T data;
	private BtreeNode<T> left;
	private BtreeNode<T> right;
	public BtreeNode(){
		left = null;
		right = null;
	}
	public void setData(T data) {
		this.data = data;
	}
	public T getData() {
		return this.data;
	}
	public void setLeft(BtreeNode<T> node){
		this.left = node;
	}
	public void setRight(BtreeNode<T> node) {
		this.right = node;
	}
	
	public BtreeNode<T> getLeft() {
		return this.left;
	}
	public BtreeNode<T> getRight() {
		return this.right;
	}
	public BtreeNode<T> getRoot(){
		return this;
	}
}
