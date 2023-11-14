package datastructure.tree;

import java.util.function.Consumer;

public interface BinaryTrees<T> {
	public BtreeNode<T> makeBtreeNode();
	public T getData(BtreeNode<T> node);
	public void setData(BtreeNode<T> node,T data);
	public BtreeNode<T> getLeftSubTree(BtreeNode<T> node);
	public BtreeNode<T> getRightSubTree(BtreeNode<T> node);
	public void makeLeftSubTree(BtreeNode<T> root, BtreeNode<T> sub);
	public void makeRightSubTree(BtreeNode<T> root, BtreeNode<T> sub);
	public BtreeNode<T> getRootNode();
	public default void InorderTraverse(BtreeNode<T> node,Consumer<BtreeNode<T>> c) {
		if(node == null) return;
		InorderTraverse(node.getLeft(),c);
		c.accept(node);
		InorderTraverse(node.getRight(),c);
	}
	
	public default void PreorderTraverse(BtreeNode<T> node,Consumer<BtreeNode<T>> c) {
		if(node == null) return;
		c.accept(node);
		PreorderTraverse(node.getLeft(),c);
		PreorderTraverse(node.getRight(),c);
	}
	public default void PostorderTraverse(BtreeNode<T> node,Consumer<BtreeNode<T>> c) {
		if(node == null) return;
		
		PostorderTraverse(node.getLeft(),c);
		PostorderTraverse(node.getRight(),c);
		c.accept(node);
	}
	
	public default void deleteNode(BtreeNode<T> node) {
		PostorderTraverse(node,n -> {
			n.setLeft(null);
			n.setRight(null);
		});
	}
	
}
