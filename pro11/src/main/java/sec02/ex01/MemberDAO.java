package sec02.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Statement stmt;
	private Connection con;
	
	private DataSource dataFactory;
	private PreparedStatement psmt;
	
	private void connDB() {
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			//커넥션
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TESTUSER2","test");
//			// statement 객체
			
			
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			con = dataFactory.getConnection();
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
	
	public void addMember(MemberVO memberVO) {
		try {
			connDB();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String sql = "INSERT INTO T_MEMBER (id,pwd,name,email) values(?,?,?,?)";
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			psmt.setString(3, name);
			psmt.setString(4, email);
			
			int result =psmt.executeUpdate();
			psmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteMember(String id) {
		try {
			connDB();
			String sql = "DELETE FROM T_MEMBER WHERE id= ?";
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.executeUpdate();
			
			psmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<MemberVO> listMembers(MemberVO member){
		List<MemberVO> memberList = new ArrayList<>();
		String _name = member.getName();
		connDB();
		try {
		String sql="select * from T_MEMBER";
		if(_name!=null && _name.length() !=0) {
			sql += " where name Like '%' || ? || '%' "; //이렇게 추가하는 거 좋다 + like쓰는법
			psmt = con.prepareStatement(sql);
			psmt.setString(1, _name);
			
		}else {
			
			psmt = con.prepareStatement(sql);
			
		}
		System.out.println(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setEmail(email);
			vo.setJoindate(joinDate);
			vo.setName(name);
			vo.setPwd(pwd);
			memberList.add(vo);
		}
		rs.close();
		psmt.close();
		con.close();
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		return memberList;
		
	}
	
}
