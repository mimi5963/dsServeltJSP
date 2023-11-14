package ch6;

public class Account {
	private final int MIN_BALANCE =0;
	private final int MAX_BALANCE = 1000000;
	private String accountNum;
	private String name;
	private int balance;
	
	
	public Account(String accountNum, String name,int val) {
		this.accountNum = accountNum;
		this.name = name;
		if(!balanceValidation(val)) {
			System.out.println("입금한도에 맞지 않습니다.");
			this.balance=0;
		}else {
		this.balance = val;
		}
	}
		
	
	public int getBalance(){
		return balance;
	}
	public void setBalance(int val) {
		if(!balanceValidation(val)) {
			System.out.println("입금 실패");
			return;
		}
		this.balance = val;
		System.out.println("입금에 성공했습니다.");
		
	}
	public void withdraw(int val) {
		if(this.balance -val >0) {
			this.balance -= val;
			System.out.println("출금이 성공했습니다.");
			return;
		}
		System.out.println("출금에 실패했습니다");
		
	}
	
	public String getName() {
		return this.name;
	}
	public String getAccountNum() {
		return this.accountNum;
	}
	private boolean balanceValidation(int val) {
		return val>=MIN_BALANCE || val<=MAX_BALANCE;
	}
	
	
}
