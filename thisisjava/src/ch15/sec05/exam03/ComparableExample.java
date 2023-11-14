package ch15.sec05.exam03;

import java.util.TreeSet;

public class ComparableExample {
	public static void main(String[] args) {
		
		TreeSet<Person> tr = new TreeSet<Person>();
		
		tr.add(new Person("홍",45));
		tr.add(new Person("홍",25));
		tr.add(new Person("홍",31));
		
		
	}
}
