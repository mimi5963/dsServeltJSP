package BiSearchTree;

public class BSearchMain {

	public static void main(String[] args) {
		BSearchTree<Integer> bst = new BSearchTree<>();
		bst.BSTInsert(9);
		bst.BSTInsert(1);
		bst.BSTInsert(6);
		bst.BSTInsert(2);
		bst.BSTInsert(8);
		bst.BSTInsert(3);
		bst.BSTInsert(5);
		
		BNode<Integer> snode =null;
		snode = bst.BSTSearch(1);
		System.out.println(snode);
		snode = bst.BSTSearch(4);
		System.out.println(snode);
		snode = bst.BSTSearch(6);
		System.out.println(snode);
		snode = bst.BSTSearch(7);
		System.out.println(snode);
	}

}
