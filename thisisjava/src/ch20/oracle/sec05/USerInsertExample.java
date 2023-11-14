package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class USerInsertExample {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		Map<String, Integer> ma = new HashMap<>();
		PreparedStatement psmt;
		try {
			//드라이버 로드
 			Class.forName("oracle.jdbc.OracleDriver");
 			//connection얻기
 			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","testuser","test1234");
			System.out.println("연결성공");
			String sql = ""+"INSERT INTO users (userid,username,userpassword,userage,useremail)"+"VALUES(?,?,?,?,?)";
			
			//sql 실행객체
			psmt = conn.prepareStatement(sql);
			//sql 실행(select -> executeQuery, insert,update,delete->executeUpdate)
			psmt.setString(1, "winter");
			psmt.setString(2, "한겨울");
			psmt.setString(3, "12345");
			psmt.setInt(4, 25);
			psmt.setString(5, "winer@mycompany.com");
			
			int rows = psmt.executeUpdate();
			System.out.println(rows);
			//실행결과 처리 
			psmt.close();

			
			
		}catch(ClassNotFoundException e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}catch(SQLException e) {
			//System.out.println("예외발생");
			e.printStackTrace();
		}finally {
			if(conn != null)
				try {
					conn.close();
					System.out.println("연결 끊기");
				}catch(SQLException e) {}
		}
	}

}
