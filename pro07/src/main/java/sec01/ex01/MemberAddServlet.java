package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member3")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doHandel(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doHandel(req,resp);
    }
    
    
	protected void doHandel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		MemberDAO dao = new MemberDAO();
		
		String command = request.getParameter("command");
		
		if("addMember".equals(command)) 
		{	
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
		
			MemberVO member = new MemberVO();
			member.setId(id);
			member.setEmail(email);
			member.setName(name);
			member.setPwd(pwd);
		
			dao.addMember(member);
		}else if("delMember".equals(command)) {
			String Delid = request.getParameter("id");
			dao.DeleteMember(Delid);
		}
		List<MemberVO> list =dao.listMembers();
		out.print("<html><body>");
		out.print("<table border=1> <tr align='center' bgcolor='lightgreeb'");
		out.print("<tr><td>아이디</td><td>비번</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for(MemberVO member : list) {
			String id = member.getId();
			String pwd = member.getPwd();
			String name = member.getName();
			String email = member.getEmail();
			Date joinDate = member.getJoindate();
			
			out.print("<tr><td>"+id+"</td><td>"+pwd+"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td><td>"
					+"<a href='/pro07/member3?command=delMember&id="+id+"'>삭제</a></td></tr>");
			
		}
		out.print("</table></body></html>");
		out.print("<a href='/pro07/memberForm.html'>새회원 등록하러 가기 </a>");
		
		
		
		
	}

}
