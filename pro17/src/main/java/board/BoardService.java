package board;

import java.util.List;

public class BoardService {
	
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public List<ArticleVO> listArticles(){
		return boardDAO.selectAllArticles();
	}

	public void addArticle(ArticleVO article) {
		boardDAO.insertNewArticle(article);
		
	}

	public ArticleVO viewArticle(int articleno) {
		ArticleVO article = null;
		article = boardDAO.selectArticle(articleno);
		return article;
	}

	public void modArticle(ArticleVO vo) {
		
		boardDAO.updateArticle(vo);
		
	}

	public void removeArticle(String articleno) {
		// TODO Auto-generated method stub
		
	}
	
}
