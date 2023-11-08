package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import sec01.ex01.MemberVO;

public class BoardDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	public BoardDAO() {
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
	
	public List<ArticleVO> selectAllArticles(){
		List<ArticleVO> list = new ArrayList<>();
		try {
			
			con = dataFactory.getConnection();
			String sql = "SELECT articleno,title,content,id,writedate,nested FROM t_BOARD"
					+ " ORDER BY gno DESC, ono ASC";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				ArticleVO vo = new ArticleVO();
				vo.setArticleno(rs.getInt("articleno"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setId(rs.getString("id"));
				vo.setWriteDate(rs.getDate("writedate"));
				vo.setNested(rs.getInt("nested"));
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	
	
	public void insertNewArticle(ArticleVO article) {
		try {
			
			con = dataFactory.getConnection();
			
			String query = "INSERT INTO t_board(articleno, title, content, imagefilename, id, gno,ono,nested) "
					+ "VALUES(SEQ_T_BOARD.NEXTVAL,?,?,?,?,SEQ_T_BOARD.CURRVAL,0,0)";
			//답글이 아닌 새글이니까 새로운 level 생성
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getImageFileName());
			pstmt.setString(4, article.getId());
			System.out.println(query);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public ArticleVO selectArticle(int articleno) {
		ArticleVO vo = new ArticleVO();
		
			try {
			
			con = dataFactory.getConnection();
			String sql = "SELECT articleno,title,content,id,writedate,imagefilename FROM t_BOARD"
					+ " WHERE articleno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				
				vo.setArticleno(rs.getInt("articleno"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setId(rs.getString("id"));
				vo.setWriteDate(rs.getDate("writedate"));
				vo.setImageFileName(rs.getString("imagefilename"));
				
				
			}
			rs.close();
			pstmt.close();
			con.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return vo;
	}

	public void updateArticle(ArticleVO article) {
			
		try {
			
			con = dataFactory.getConnection();
			
			String query = "UPDATE t_board SET title=?, content=? ";
			if(article.getImageFileName() != null && !"".equals(article.getImageFileName())) {
				query += ", imagefilename=? ";
			}
			query += " WHERE articleno = ?";
			
			int cnt = 1;
			pstmt = con.prepareStatement(query);
			pstmt.setString(cnt++, article.getTitle());
			pstmt.setString(cnt++, article.getContent());
			if(article.getImageFileName() != null && !"".equals(article.getImageFileName())) {
				pstmt.setString(cnt++, article.getImageFileName());
			}
			pstmt.setInt(cnt++, article.getArticleno());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//이미지 파일명 리턴 (이거 이름 받아서 자바코드로 실제 이미지 지울꺼임)
	public List<String> selectImage(String articleno){
		List<String> list = new ArrayList<>();
		try {
			
			con = dataFactory.getConnection();
			String sql = "SELECT imagefilename FROM t_BOARD"
					+ " WHERE gno="+articleno;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("imagefilename"));
			}
			rs.close();
			pstmt.close();
			con.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//delete (사진따로 글따로 지우려구함)
	
	public int deleteArticle(String articleno) {
		int result = 0;
		
		try {
			
			con = dataFactory.getConnection();
			
			String query = "DELETE FROM t_board WHERE gno=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, articleno);
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	
	
	
	
	
}
