package ch6;

public class AccountList {
	Account[] list;
	int size;
	public AccountList() {
		list = new Account[100];
		size=0;
	}
	
	
	public boolean push(Account ac) {
			Account re = findAccount(ac.getAccountNum());
			if(re==null) {
			list[size++] = ac;
			return true;
			}
		return false;
	}
	public void getList() {
		if(size == 0) {
			System.out.println("등록된 계좌가 없습니다");
			return;
		}
		System.out.println("-----계좌 목록 ------");
		for(int i=0; i<size;i++) {
			Account a = list[i];
			System.out.println(a.getAccountNum() +" "+ a.getName() +" "+ a.getBalance());
		}
	}
	
	public void withdraw(String accountnum, int val) {
		
		
		Account re = findAccount(accountnum);
		if(re != null) {
			re.withdraw(val);
			return;
		}
		
		System.out.println("출금실패 계좌번호를 확인하세요");
		
	}
	
	public void moneyIn(String accountnum, int val) {
		
		
		Account re = findAccount(accountnum);
		if(re != null) {
			re.setBalance(val+re.getBalance());
			return;
		}
		
			System.out.println("입금 실패 계좌번호 확인하세요");
		
	}
	
	private boolean sameAccountNum(String accountnum1, String accountnum2) {
		return accountnum1.equals(accountnum2);
	}
	
	
	private Account findAccount(String number) {
		Account re = null;
		for(int i=0; i<size;i++) {
			if(sameAccountNum(list[i].getAccountNum(),number)) {
				re = list[i];
			}
		}
		return re;
	} //모듈화란 하나의 프로세스로 만들어서 공통처리한다.



}
