package TreeAndHeap;

public class TreeTest {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree();
		tree.setData(tree.getRoot(), 1);
		
		Tree.Node<Integer> n2 = Tree.makeNode();
		Tree.Node<Integer> n3 = Tree.makeNode();
		Tree.Node<Integer> n4 = Tree.makeNode();
		tree.setData(n2, 2);
		tree.setData(n3, 3);
		tree.setData(n4, 4);
		
		tree.makeLeftNode(tree.getRoot(), n2);
		tree.makeRightNode(tree.getRoot(), n3);
		tree.makeLeftNode(n2, n4);
		
		tree.inorderTraverse(tree.getRoot(), (n) -> {
			System.out.print(n.data);
		});
		System.out.println();
		tree.preorderTraverse(tree.getRoot(), (n) ->{
			System.out.print(n.data);
		});
		System.out.println();
		tree.postorderTraverse(tree.getRoot(), (n)->{
			System.out.print(n.data);
		});
		
		Tree.Node<Integer> n5 = Tree.makeNode();
		Tree.Node<Integer> n6 = Tree.makeNode();
		Tree.Node<Integer> n7 = Tree.makeNode();
		tree.setData(n5, 5);
		tree.setData(n6, 6);
		tree.setData(n7, 7);
		tree.makeLeftNode(n5, n6);
		tree.makeRightNode(n5, n7);
		tree.makeRightNode(n2, n5);
		System.out.println();
		tree.inorderTraverse(tree.getRoot(), (n) -> {
			System.out.print(n.data);
		});
		System.out.println();
		tree.preorderTraverse(tree.getRoot(), (n) ->{
			System.out.print(n.data);
		});
		System.out.println();
		tree.postorderTraverse(tree.getRoot(), (n)->{
			System.out.print(n.data);
		});
		
		tree.deleteNode(n5);
		System.out.println();
		tree.inorderTraverse(tree.getRoot(), (n) -> {
			System.out.print(n.data);
		});
		System.out.println();
		tree.preorderTraverse(tree.getRoot(), (n) ->{
			System.out.print(n.data);
		});
		System.out.println();
		tree.postorderTraverse(tree.getRoot(), (n)->{
			System.out.print(n.data);
		});
		
	}
	

}
