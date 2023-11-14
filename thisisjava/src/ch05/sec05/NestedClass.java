package ch05.sec05;

public class NestedClass {
	private NestedClass() {}
	
	private static class SingleInstanceHolder{
		private  NestedClass ns = new NestedClass();
	}
	
}
