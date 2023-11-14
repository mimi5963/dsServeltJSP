package exam.members;

import java.util.Scanner;

public class UserService {
	
	private UserTabel ut;
	
	private static UserService us;
	
	private UserService() {
		ut = new UserTabel();
	}
	
	public static UserService getUserService() {
		if(us == null) {
			us = new UserService();
		}
		return us;
	}
	
	public void showMenu() {
		System.out.println("1. 회원등록 | 2. 회원목록 | 3.회원상세 | 4. 회원수정 | 5.종료");
	}
	
	//입력받은 id, pass, name을 테이블에 저장 
	public void memberInsert(String id, String pass, String name) {
		
		boolean result = ut.insert(id, pass, name);
		
		if(!result) {
			System.out.println("중복된 아이디 입니다.");
			return;
		}
		
		System.out.println("회원등록 성공");
	}
	
	//테이블에 저장된 모든 멤버릴 출력
	public void showMemberList() {
		System.out.println("번호\t아이디\t비밀번호\t이름");
		for(User s: ut.getUserList()) {
	
			System.out.println(s.getNo()+"\t"+s.getId()+"\t"+s.getPwd()+"\t"+s.getName());
		}
		
	}
	
	//입력받은 id로 찾아서, 상세정보 보여줌
	public void memberContent(String id) {
		
		User find =ut.findUser(id);
		if(find == null) {
			System.out.println("해당 아이디가 존재하지 않습니다.");
			return;
		}
		
		System.out.println("번호 : " + find.getNo());
		System.out.println("아이디 : " + find.getId());
		System.out.println("이름 : "+find.getName());
		System.out.println("비밀번호 : "+find.getPwd());
		
	}
	
	//회원 정보 수정 
	public void updateUser(String id, String pass, String name) {
		
		boolean result = ut.update(id, name, name);
		if(!result) {
			System.out.println("해당 아이디가 존재하지 않습니다.");
			return;
		}
		
		System.out.println("정상적으로 수정되었습니다.");
	}
	

}
