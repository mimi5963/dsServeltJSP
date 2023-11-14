package decorator;

public class SratCoffee {

	public static void main(String[] args) {
		Beverage bver = new Espresso(Size.GRANDE);
		System.out.println(bver.getDescription()+"$"+bver.cost());
	
		Beverage br2 = new HouseBlend(Size.VENTI);
		br2 = new Mocha(br2);
		System.out.println(br2.getDescription()+br2.cost());
		br2 = new Mocha(br2); // 모카 다시 추가
		System.out.println(br2.getDescription()+br2.cost());
		br2 = new Soy(br2);
		System.out.println(br2.getDescription()+br2.cost());
	}

}
