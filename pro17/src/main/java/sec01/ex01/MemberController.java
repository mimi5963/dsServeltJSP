package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;
	
	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MemberDAO();
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
		
		if(action == null || "/listMember.do".equals(action)) {
			
			request.setAttribute("membersList", memberDAO.listMembers(new MemberVO()));
			nextPage = "/test01/listMembers.jsp";
		}else if("/addMember.do".equals(action)) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO member = new MemberVO(id,pwd,name,email);
			memberDAO.addMember(member);
			nextPage = "redirect:listMembers.do";
		}else if("/memberForm.do".equals(action)) {
			nextPage = "/test01/memberForm.jsp";
		}else if("/modMember.do".equals(action)) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO member = new MemberVO(id,pwd,name,email);
			memberDAO.modMember(member);
			nextPage = "redirect:listMember.do";
		}else if("/modMemberForm.do".equals(action)) {
			String id = request.getParameter("id");
			MemberVO memInfo =  memberDAO.findMember(id);
			request.setAttribute("memInfo", memInfo);
			nextPage = "/test01/modMemberForm.jsp";
		}else if("/delMember.do".equals(action)) {
			String id = request.getParameter("id");
			memberDAO.delMember(id);
			nextPage = "redirect:listMember.do";
		}
		else {
			request.setAttribute("memberList", memberDAO.listMembers(new MemberVO()));
			nextPage = "/test01/listMembers.jsp";
		}
		
		
		
		if(nextPage.startsWith("redirect:")) {
			response.sendRedirect(nextPage.replace("redirect:", ""));
		}else {
		
		request.getRequestDispatcher(nextPage).forward(request, response);
		}
	}

}
