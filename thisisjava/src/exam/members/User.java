package exam.members;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	private int no;
	private String id;
	private String pwd;
	private String name;
	
	public User(int no, String id, String pwd, String name) {
		this.no = no;
		this.id = id;
		this.pwd =pwd;
		this.name = name;
	}
}
