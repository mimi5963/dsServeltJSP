package board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardService boardService;
	
	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("실행로직");
		String nextPage = null;
		String action = request.getPathInfo();
		System.out.println("action = "+action);
		
		if(action == null || "/listArticles.do".equals(action)) {
			
			request.setAttribute("articlesList", boardService.listArticles());
			nextPage = "/WEB-INF/view/board/listArticles.jsp";
		}else if("/addArticle.do".equals(action)) {
			Map<String,String> articleMap = upload(request,response);
			ArticleVO vo = new ArticleVO();
			vo.setTitle(articleMap.get("title"));
			vo.setContent(articleMap.get("content"));
			vo.setImageFileName(articleMap.get("imageFileName"));
			vo.setId("hong"); //추후에는 로그인한 아이디 session에서 id나 이름을 빼서 넣어야함!! 그래야 지가 쓴 글 
			boardService.addArticle(vo);
			
			nextPage ="redirect:listArticles.do";
		}else if("/articleForm.do".equals(action)) {
			nextPage = "/WEB-INF/view/board/articleForm.jsp";
		}else if("/modArticle.do".equals(action)) {
			
			Map<String,String> articleMap = upload(request,response);
			ArticleVO vo = new ArticleVO();
			vo.setArticleno(Integer.parseInt(articleMap.get("articleno")));
			vo.setTitle(articleMap.get("title"));
			vo.setContent(articleMap.get("content"));
			vo.setImageFileName(articleMap.get("imageFileName"));
			vo.setId("hong"); //추후에는 로그인한 아이디 session에서 id나 이름을 빼서 넣어야함!! 그래야 지가 쓴 글 
			boardService.modArticle(vo);
			
			nextPage ="redirect:listArticles.do";
		}else if("/modArticleForm.do".equals(action)) {
			String articleno = request.getParameter("articleno");
			request.setAttribute("articleno", articleno);
			
			nextPage = "/WEB-INF/view/board/modArticleForm.jsp";
		}else if("/viewArticle.do".equals(action)) {
			System.out.println("실행");
			String articleno = request.getParameter("articleno");
			System.out.println(articleno +"번호");
			ArticleVO vo = boardService.viewArticle(Integer.parseInt(articleno));
			request.setAttribute("article", vo);
			nextPage = "/WEB-INF/view/board/viewArticle.jsp";
			System.out.println(vo);
		}else if("/removeArticle.do".equals(action)) {
			
			String articleno = request.getParameter("articleno");
			boardService.removeArticle(articleno);
			nextPage = "redirect:listArticles.do";
			
		}
		
		
		
		
		if(nextPage.startsWith("redirect:")) {
			response.sendRedirect(nextPage.replace("redirect:", ""));
		}else {
		
		request.getRequestDispatcher(nextPage).forward(request, response);
		}
	}
	
	//파일 업로드 라이브러리를 이용해서 파라미터, 파일 처리 후에 Map 객체에 담아 리턴 
	private Map<String,String> upload(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		Map<String,String> articleMap = new HashMap<>();
		
		String encoding = "utf-8";
		String realPath = request.getRealPath("/upload/article_image"); // /<- webapp/upload/article_image 폴더
		File currentDirPath = new File(realPath);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List items = upload.parseRequest(request);
			for (int i=0; i<items.size(); i++) {
				FileItem fileItem = (FileItem)items.get(i);
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding)); //태그 name영역 
					
				} else {
					System.out.println("매개변수이름:"+fileItem.getFieldName()); //input type 태그 name
					System.out.println("파일이름:"+fileItem.getName()); //이건 파일이름
					System.out.println("파일크기:"+fileItem.getSize()+"bytes");
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx+1);
						articleMap.put(fileItem.getFieldName(), fileName);
						File uploadFile = new File(currentDirPath+"\\"+fileName);
						fileItem.write(uploadFile);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return articleMap;
	}
	
	

}
