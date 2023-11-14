package searchTree;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		SearchTreeEx2<Integer> ST = new SearchTreeEx2(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1-o2;
			}
			
		});
		
		ST.BSTinsert(2);
		ST.BSTinsert(1);
		ST.BSTinsert(5);
		ST.BSTinsert(6);
		ST.printAll();
		System.out.println();
		ST.delete(2);
		ST.printAll();
	}

}
