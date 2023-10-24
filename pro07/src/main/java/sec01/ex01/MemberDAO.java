package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Statement stmt;
	private Connection con;
	
	
	private void connDB() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//커넥션
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TESTUSER2","test");
			// statement 객체
			stmt = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		
		List<MemberVO> memberList= new ArrayList<>();
		try {
			connDB();
			String sql = "SELECT * FROM T_MEMBER";
			ResultSet rs = stmt.executeQuery(sql);
		
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPwd(rs.getString("pwd"));
				member.setEmail(rs.getString("email"));
				member.setJoindate(rs.getDate("joindate"));
				memberList.add(member);
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return memberList;
		
	}
	
	
}
