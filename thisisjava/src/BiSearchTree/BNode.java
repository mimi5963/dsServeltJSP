package BiSearchTree;

public class BNode<T> {
	T data;
	BNode<T> left;
	BNode<T> right;
	public BNode(){
		this(null);
	}
	public BNode(T data){
		this.data =data;
		left =null;
		right =null;
	}
}
