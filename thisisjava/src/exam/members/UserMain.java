package exam.members;

import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) {
		//서비스와 스캐너 
		UserService us = UserService.getUserService();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			//메뉴화면을 보여주는 메서드
			us.showMenu();
			int choice=-1;
			try {
			System.out.print("입력]");
			choice = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				//숫자로 변환될 수 있는 문자가 아닐 때 발생하는 에러를 잡음
				System.out.println("잘못입력하셨습니다. 1~5 범위로 다시 입력해주세요");
				continue;
			}
			
			if(choice == 1) {
				System.out.println("[회원등록]");
				String[] input = idAndPassAndName(sc);
				us.memberInsert(input[0], input[1], input[2]);
			}else if(choice == 2) {
				us.showMemberList();
			}else if(choice == 3) {
				System.out.println("[회원상세]");
				System.out.print("아이디:");
				String id = sc.nextLine();
				us.memberContent(id);
			}else if(choice == 4) {
				System.out.println("[회원수정]");
				String[] input = idAndPassAndName(sc);
				us.updateUser(input[0],input[1],input[2]);
			}else if(choice == 5){
				break;
			}else {
				//메뉴의 범위에 넘어가는 입력처리
				System.out.println("메뉴는 1-5까지 입니다. 다시 입력하세요");
			}
		}
		System.out.println("종료");
		
	}
	
	public static String[] idAndPassAndName(Scanner sc) {
		//공통으로 입렫받는 아이디와 비밀번호 이름 처리
		System.out.print("아이디:");
		String id = sc.nextLine();
		System.out.print("비밀번호:");
		String pass = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		return new String[] {id,pass,name};
	}
}
