package datastructure.tree;

import java.util.function.Consumer;

public class BinaryTree<T> implements BinaryTrees<T>{
	private BtreeNode<T> root;
	
	public BinaryTree(BtreeNode<T> roots){
		this.root =roots;
	}
	@Override
	public BtreeNode<T> makeBtreeNode() {
		BtreeNode<T> nd = new BtreeNode<>();
		
		return nd;
	}

	@Override
	public T getData(BtreeNode<T> node) {
		
		return node.getData();
	}

	@Override
	public void setData(BtreeNode<T> node, T data) {
		node.setData(data);
		
	}

	@Override
	public BtreeNode<T> getLeftSubTree(BtreeNode<T> node) {
		
		return node.getLeft();
	}

	@Override
	public BtreeNode<T> getRightSubTree(BtreeNode<T> node) {
		
		return node.getRight();
	}

	@Override
	public void makeLeftSubTree(BtreeNode<T> root, BtreeNode<T> sub) {
		if(root.getLeft() != null) {
			root.setLeft(null); 
		}
		root.setLeft(sub);
		
	}

	@Override
	public void makeRightSubTree(BtreeNode<T> root, BtreeNode<T> sub) {
		if(root.getRight() != null) {
			root.setRight(null);
		}
		root.setRight(sub);
		
	}
	
	public void deleteNode(BtreeNode<T> node) {
		
		PostorderTraverse(node,n -> {
			n.setLeft(null);
			n.setRight(null);
		});
		
		if(node == this.root) {
			root = null;
			return;
		}
		
		findNode(root,node);
		
		
		   
	}

	private void findNode(BtreeNode<T> root2, BtreeNode<T> node) {
		if(root2 == null) {
			return;
		}
		
		
		findNode(root2.getLeft(),node);
		findNode(root2.getRight(),node);
		if(root2.getLeft() == node) {
			root2.setLeft(null);
		}
		if(root2.getRight() == node) {
			root2.setRight(null);
		}
		
	}
	@Override
	public BtreeNode<T> getRootNode() {
		
		return this.root;
	}
	


}
