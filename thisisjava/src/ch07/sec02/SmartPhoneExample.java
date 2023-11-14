package ch07.sec02;

public class SmartPhoneExample {

	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("갤럭시","은색");
		System.out.println(myPhone.model);
		System.out.println(myPhone.color);
		
		System.out.println("와이파이 상태"+myPhone.wifi);
		
		myPhone.bell();
		myPhone.sendVoice("여보");
		myPhone.receiveVoice("안녕하세요 저는 길동홍");
		myPhone.sendVoice("예 반가워요");
		
		
	}

}
