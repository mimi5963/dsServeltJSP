package exam.members;

import java.util.ArrayList;
import java.util.List;

public class UserTabel {
	private List<User> userList;
	private int no;
	
	public UserTabel() {
		userList = new ArrayList<>();
		no = 1;
	}
	
	public User getUser(int no,String id, String pwd, String name) {
		return new User(no,id,pwd,name);
	}
	
	public boolean insert(String id, String pwd, String name) {
		if(findUser(id) != null) {
			return false;
		}
		userList.add(new User(no++,id,pwd,name));
		return true;
	}
	
	public User findUser(String id) {
		User result =null;
		
		for(User u : userList) {
			if(u.getId().equals(id))
			{
				result = u;
				break;
			}
		}
		
		return result;
	}
	
	public boolean update(String id, String name, String pwd) {
		User updateUser = findUser(id);
		if(updateUser == null) return false;
		updateUser.setName(name);
		updateUser.setPwd(pwd);
		return true;
	}
	public List<User> getUserList(){
		return userList;
	}
}
