package BiSearchTree;

public class BTEst {

	public static void main(String[] args) {
		BineryTree<Integer> bt = new BineryTree<Integer>();
		BNode<Integer> n1= BineryTree.makeNode();
		BNode<Integer> n2= BineryTree.makeNode();
		BNode<Integer> n3= BineryTree.makeNode();
		BNode<Integer> n4= BineryTree.makeNode();
		BNode<Integer> n5= BineryTree.makeNode();
		n1.data =1;
		n2.data=2;
		n3.data =3;
		n4.data=4;
		n5.data=5;
		
		bt.setLeftSubTree(n1, n2);
		bt.setRightSubTree(n1, n3);
		bt.setLeftSubTree(n2, n4);
		bt.setRightSubTree(n2, n5);
		
		bt.introTraverse(n1, (n) -> {
			System.out.print(n.data);
		});
		
		
		BNode<Integer> n6= BineryTree.makeNode();
		BNode<Integer> n7= BineryTree.makeNode();
		BNode<Integer> n8= BineryTree.makeNode();
		n6.data = 6;
		n7.data = 7;
		n8.data= 8;
		
		bt.setLeftSubTree(n6, n7);
		bt.setRightSubTree(n6, n8);
		bt.setRightSubTree(n3, n6);
		System.out.println();
		bt.introTraverse(n1, (n) -> {
			System.out.print(n.data);
		});
		System.out.println();
		BNode<Integer> n9= BineryTree.makeNode();
		n9.data = 10;
		bt.setRightSubTree(n3,n9);
		bt.introTraverse(n1, (n) -> {
			System.out.print(n.data);
		});
	}

}
