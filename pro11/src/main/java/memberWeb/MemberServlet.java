package memberWeb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec02.ex01.MemberDAO;
import sec02.ex01.MemberVO;


@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	public void doHandle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//파라미터 받기
		String searchWord = request.getParameter("searchWord");
		
		//데이터 조회
		MemberVO member = new MemberVO();
		member.setName(searchWord);
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO>list=dao.listMembers(member);
		
		//데어터 저장 
		request.setAttribute("list", list);
		
	     request.getRequestDispatcher("/memberList.jsp").forward(request, response);
		
		
	}
}
