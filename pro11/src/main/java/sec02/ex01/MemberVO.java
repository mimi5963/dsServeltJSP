package sec02.ex01;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class MemberVO {
	private String id;
	private String pwd;
	private String name; 
	private String email;
	private Date joindate;

	public String getName2() {
		return name+"님 안녕하세요";
	}
}
