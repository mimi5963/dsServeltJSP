package sec02.ex09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			con = dataFactory.getConnection();
			stmt = con.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isExisted(MemberVO memberVO) {
		boolean result = false;
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		connDB();
		
		String query = "select decode(count(*),1,'true','false') as result from T_MEMBER WHERE id =? and pwd = ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			
			ResultSet rs =psmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result ="+result);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return result;
	}
	
}
