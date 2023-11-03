package sec01.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			con = dataFactory.getConnection();
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO isExisted(MemberVO memberVO) {
		MemberVO result = null;
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member where id=? and pwd=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new MemberVO();
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				result.setEmail(rs.getString("email"));
				result.setJoindate(rs.getDate("joindate"));
				
			}
//			result = rs.getInt("cnt") == 1 ? true : false;
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public List listMembers(MemberVO memberVO) {
		List<MemberVO> memberList = new ArrayList();
		String _name = memberVO.getName();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			if ((_name != null && _name.length() != 0)) {
				query += " where name like '%' || ? || '%' ORDER BY joindate DESC";
				System.out.println(query);
				System.out.println(_name);
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, _name);
			} else {
				query += " ORDER BY joindate DESC";
				pstmt = con.prepareStatement(query);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next() ) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoindate(rs.getDate("joindate"));
				memberList.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	public boolean overlappedID(String id) {
		boolean result = false;
		try {
			con = dataFactory.getConnection();
			String query = "select count(*) as cnt from t_member where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt("cnt") > 0 ? true : false;
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void addMember(MemberVO m) {
		try {
			
			con = dataFactory.getConnection();
			String id= m.getId();
			String pwd= m.getPwd();
			String name= m.getName();
			String email = m.getEmail();
			String query = "INSTER INTO t_member(id,pwd,name,eamil) VALUES(?,?,?,?)";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public MemberVO findMember(String id) {
		MemberVO memInfo = null;
		try {
			
			con=dataFactory.getConnection();
			String query = "select * from t_member where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			System.out.println(query);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				memInfo = new MemberVO(rs.getString("id"),rs.getString("pwd"),rs.getString("name"),rs.getString("email"),rs.getDate("joindate"));
			}
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();		
			}
		
		return memInfo;
	}
	
	public void modMember(MemberVO m) {
		try {
			
			con = dataFactory.getConnection();
			String id= m.getId();
			String pwd= m.getPwd();
			String name= m.getName();
			String email = m.getEmail();
			String query = "UPDATE t_member SET pwd=?,name=?,email=? WHERE id=?";
			System.out.println(email);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void delMember(String id) {
	
		try {
			
			con=dataFactory.getConnection();
			String query = "DELETE from t_member WHERE id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();		
			}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
