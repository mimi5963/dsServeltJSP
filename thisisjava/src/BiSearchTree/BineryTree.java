package BiSearchTree;

import java.util.function.Consumer;

public class BineryTree<T> {
	
	
	public static <T> BNode<T> makeNode(){
		return new BNode<T>();
	}
	
	public T getData(BNode<T> node) {
		return node.data;
	}
	public BNode<T> getLeftSubTree(BNode<T> node){
		return node.left;
	}
	public BNode<T> getRightSubTree(BNode<T> node){
		return node.right;
	}
	public void setLeftSubTree(BNode<T> root, BNode<T> sub) {
		if(root.left != null) {
			root = deleteNode(root,root.left);
		}
		root.left =sub;
	}
	private BNode<T> deleteNode(BNode<T> cur,BNode<T> target) {
		if(cur == null) return null;
		if(cur == target) {
			postOrderTraverse(cur,(t) -> {
				t.left = null;
				t.right = null;
			});
			return null;
		}else {
			cur.left = deleteNode(cur.left,target);
			cur.right = deleteNode(cur.right,target);
		}
		
		return cur;
	}

	public void setRightSubTree(BNode<T> root, BNode<T> sub) {
		if(root.right != null) {
			root = deleteNode(root,root.right);
		}
		root.right=sub;
	}
	
	public void introTraverse(BNode<T> cur , Consumer<BNode<T>> c) {
		if(cur == null) return;
		introTraverse(cur.left,c);
		c.accept(cur);
		introTraverse(cur.right,c);
	}
	public void preOrderTraverse(BNode<T> cur, Consumer<BNode<T>> c ) {
		if(cur == null) return;
		c.accept(cur);
		preOrderTraverse(cur.left,c);
		preOrderTraverse(cur.right,c);
		
	}
	public void postOrderTraverse(BNode<T> cur, Consumer<BNode<T>> c) {
		if(cur == null) return;
		postOrderTraverse(cur.left,c);
		postOrderTraverse(cur.right,c);
		c.accept(cur);
	}
	
	public void ChangeLeftSubTree(BNode<T> main, BNode<T> sub) {
		main.left = sub;
	}
	
	public void ChangeRightSubTree(BNode<T> main, BNode<T> sub) {
		main.right = sub;
	}
	
	public BNode<T> RemoveLeftSubTree(BNode<T> bt){
		BNode<T> delNode =null;
		if(bt != null) {
			delNode = bt.left;
			bt.left = null;
		}
		return delNode;
	}
	public void setData(BNode<T> cur, T data) {
		cur.data = data;
	}
	public BNode<T> RemoveRightSubTree(BNode<T> bt){
		BNode<T> delNode =null;
		
		if(bt != null) {
			delNode = bt.right;
			bt.right = null;
		}
		return delNode;
	}
}
