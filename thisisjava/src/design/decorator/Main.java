package design.decorator;

public class Main {

	public static void main(String[] args) {
		
		Basic ame = new Americano(1,2000);
		
		System.out.println(ame.getPrice());
		System.out.println(ame.getShot());
		
		Basic es = new Espresso(ame,2,1000);
		System.out.println(es.getPrice());
		System.out.println(es.getShot());
	}

}
