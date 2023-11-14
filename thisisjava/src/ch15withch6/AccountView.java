package ch15withch6;

import java.util.Scanner;

public class AccountView {
	AccountList list;
	Scanner sc = new Scanner(System.in);
	public AccountView(AccountList list) {
		this.list = list;
	}
	
	public void createAccount() {
		System.out.println("-------------");
		System.out.println("계좌생성");
		System.out.println("--------------");
		System.out.print("계좌번호 : ");
		String num = sc.nextLine();
		System.out.println();
		System.out.print("계좌주 : ");
		String name = sc.nextLine();
		System.out.println();
		System.out.print("초기 입금액");
		int bal = Integer.parseInt(sc.nextLine());
		Account newacc = new Account(num,name,bal);
		boolean result = list.push(newacc);
		if(!result) {
		System.out.println("결과: 계좌가 생성실패. (계좌번호 중복)");
		return;
		}
		System.out.println("결과: 계좌 생성 성공");
		
	}
	public void showList() {
		System.out.println("--------------");
		System.out.println("계좌목록");
		System.out.println("--------------");
		list.getList();
	}
	public void putMoney() {
		System.out.println("--------------");
		System.out.println("입금");
		System.out.println("---------------");
		System.out.print("계좌번호 : ");
		String num = sc.nextLine();
		System.out.println();
		System.out.print("입금액 : ");
		int val = Integer.parseInt(sc.nextLine());
		list.moneyIn(num, val);
	}
	
	public void getMoney() {
		System.out.println("--------------");
		System.out.println("출금");
		System.out.println("---------------");
		System.out.print("계좌번호 : ");
		String num = sc.nextLine();
		System.out.println();
		System.out.print("출금액 : ");
		int val = Integer.parseInt(sc.nextLine());
		list.withdraw(num, val);
	}
	

	
	
}
