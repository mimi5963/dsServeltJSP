package datastructure.tree;

import java.util.function.Consumer;

public class TreeMain {

	public static void main(String[] args) {
		
		
		BinaryTrees<Integer> bt = new BinaryTree<Integer>(new BtreeNode<Integer>());
		BtreeNode<Integer> n2 = bt.makeBtreeNode();
		BtreeNode<Integer> n3 = bt.makeBtreeNode();
		BtreeNode<Integer> n4 = bt.makeBtreeNode();
		
		BtreeNode<Integer> n5 = bt.makeBtreeNode();
		BtreeNode<Integer> n6 = bt.makeBtreeNode();
		BtreeNode<Integer> n7 = bt.makeBtreeNode();
		bt.setData(n5, 5);
		bt.setData(n6, 6);
		bt.setData(n7, 7);
	    bt.makeLeftSubTree(n5, n6);
	    bt.makeRightSubTree(n5, n7);
	    bt.makeRightSubTree(n2, n5);
   		
		
		bt.setData(bt.getRootNode(), 1);
		bt.setData(n2, 2);
		bt.setData(n3, 3);
		bt.setData(n4, 4);
		
		bt.makeLeftSubTree(bt.getRootNode(), n2);
		bt.makeRightSubTree(bt.getRootNode(), n3);
		bt.makeLeftSubTree(n2, n4);
		
		System.out.println(bt.getData(bt.getLeftSubTree(bt.getRootNode())));
		System.out.println(bt.getData(bt.getLeftSubTree(bt.getLeftSubTree(bt.getRootNode()))));
		System.out.println();
		
		Consumer<BtreeNode<Integer>> c = (n) ->{
			System.out.print(n.getData());
		};
		bt.InorderTraverse(bt.getRootNode(), c);
		System.out.println();
		bt.PreorderTraverse(n4, c);
		System.out.println();
		bt.PreorderTraverse(bt.getRootNode(), c);
		System.out.println();
		bt.PostorderTraverse(n2, c);
		System.out.println();
		bt.PostorderTraverse(bt.getRootNode(), c);
		System.out.println();
		
		bt.deleteNode(n5);
		bt.InorderTraverse(bt.getRootNode(), c);
		System.out.println();
		bt.PreorderTraverse(bt.getRootNode(), c);
		System.out.println();
		bt.PostorderTraverse(bt.getRootNode(), c);
		
	}

}
