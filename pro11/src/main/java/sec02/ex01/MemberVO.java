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

}
