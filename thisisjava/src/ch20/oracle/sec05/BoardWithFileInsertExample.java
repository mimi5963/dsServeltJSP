package ch20.oracle.sec05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class BoardWithFileInsertExample {

	public static void main(String[] args) throws FileNotFoundException {
		
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
			String sql = ""+"INSERT INTO boards (bno,btitle,bcontent,bwriter,bdate,bfilename,bfiledate)"+
			"VALUES(SEQ_BNO.NEXTVAL,?,?,?,SYSDATE,?,?)";
			
			//sql 실행객체
			psmt = conn.prepareStatement(sql,new String[] {"bno"});//execute업데이트 실행하고 이 컬럼을 가져옴 후에 값 읽으려고
			psmt.setString(1, "눈 오는 날");
			psmt.setString(2, "함박눈이 내려요");
			psmt.setString(3,"winter");
			psmt.setString(4, "snow.jpg");
			psmt.setBlob(5, new FileInputStream("D:/Java/workspace/thisisjava/src/ch20/oracle/sec05/snow.jpg"));
			//sql 실행(select -> executeQuery, insert,update,delete->executeUpdate)
			
			
			
			int rows = psmt.executeUpdate();
			System.out.println(rows);
			//실행결과 처리 
			if(rows == 1) {
				rs = psmt.getGeneratedKeys(); //맨 마지막에 등록된 것 하나만 읽을 수 있다.
				if(rs.next()) {
					int bon = rs.getInt(1);//설정 된 컬럼에서 맨 마지막으로 등록된 값 읽어옴
					System.out.println("저장된 bno"+bon);
				}
				rs.close();
			}
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
