package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ConnectionExample {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		Map<String, Integer> ma = new HashMap<>();
		
		try {
			//드라이버 로드
 			Class.forName("oracle.jdbc.OracleDriver");
 			//connection얻기
 			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","testuser","test1234");
			System.out.println("연결성공");
			//sql 실행객체
			stmt = conn.createStatement();
			//sql 실행(select -> executeQuery, insert,update,delete->executeUpdate)
			rs = stmt.executeQuery("select * from student");
			//실행결과 처리 
			while(rs.next()) {
				System.out.println(rs.getString("name")+"\t"+rs.getString("id"));
			}
			
			
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
