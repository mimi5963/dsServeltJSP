package searchTree;

import java.util.function.Consumer;

public class Tree<T> {

	public static <T> node<T> makeNewNode(){
		return new node<T>(null);
	}
	public void setData(node<T> cur,T data) {
		cur.setData(data);
	}
	public T getData(node<T> cur) {
		return cur.getData();
	}
	public void setLeftNode(node<T> cur, node<T> left) {
		if(cur.getleft() != null) {
			cur.setLeft(deleteNode(cur.getleft(),left));
		}
		cur.setLeft(left);
	}
	public void setRightNode(node<T> cur, node<T> right) {
		if(cur.getRight() != null) {
			cur.setRight(deleteNode(cur.getRight(),right));
		}
		cur.setRight(right);
	}
	public node<T> getLeft(node<T> cur) {
		return cur.getleft();
	}
	public node<T> getRight(node<T> cur){
		return cur.getRight();
	}
	
	public void preOrderTraverse(node<T> cur, Consumer<node<T>> c) {
		if(cur == null)return;
		c.accept(cur);
		preOrderTraverse(cur.getleft(), c);
		preOrderTraverse(cur.getRight(),c);
	}
	public void postOrderTraverse(node<T> cur, Consumer<node<T>> c) {
		if(cur == null)return;
		postOrderTraverse(cur.getleft(),c);
		postOrderTraverse(cur.getRight(),c);
		c.accept(cur);
	}
	public void inOrderTraverse(node<T> cur, Consumer<node<T>> c) {
		if(cur == null)return;
		inOrderTraverse(cur.getleft(),c);
		c.accept(cur);
		inOrderTraverse(cur.getRight(),c);
	}
	
	public node<T> deleteNode(node<T> cur, node<T> delete){
		if(cur == null) return null;
		
		if(cur == delete) {
			postOrderTraverse(cur,(c) -> {
				c.setLeft(null);
				c.setRight(null);
			});
			return null;
		}else {
			cur.setLeft(deleteNode(cur.getleft(),delete));
			cur.setRight(deleteNode(cur.getRight(),delete));
		}
		
		
		return cur;
	}
	
	//확장 
	public node<T> removeLeftSubTree(node<T> root){
		node<T> delNode = null;
		if(root.getleft() != null) {
			delNode = root.getleft();
			root.setLeft(null);
		}
		return delNode;
	}
	public node<T> removeRightSubTree(node<T> root){
		node<T> delNode = null;
		if(root.getRight() != null) {
			delNode = root.getRight();
			root.setRight(null);
		}
		return delNode;
	}
	
	public void ChangeLeftSubTree(node<T> cur, node<T> sub) {
		cur.setLeft(sub);
	}
	public void ChangeRightSubTree(node<T> cur, node<T> sub) {
		cur.setRight(sub);
	}
	
	
	
}
