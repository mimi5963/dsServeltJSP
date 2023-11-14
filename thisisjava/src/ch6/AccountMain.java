package ch6;

import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			boolean flag = true;
			AccountView av = new AccountView(new AccountList());
			while(flag) {
				System.out.println("-----------------------------------");
				System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
				System.out.println("----------------------------------");
				System.out.println("선택 >");
				int ch = Integer.parseInt(sc.nextLine());
				
				switch(ch) {
				case 1:
					av.createAccount();
					break;
				case 2:
					av.showList();
					break;
				case 3:
					av.putMoney();
					break;
				case 4:
					av.getMoney();
					break;
				default :
					flag = false;
				}
			}
			System.out.println("프로그램 종료");
	}
	

}
