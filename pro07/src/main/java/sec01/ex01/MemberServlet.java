package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		MemberDAO  dao = new MemberDAO();
		
		List<MemberVO> memberList = dao.listMembers();
		
	
		
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<table border=1 style='border-collapse:collapse'>");
		pw.print("<tr style='background-color:lightgreen';>");
		pw.print("<th>아이디</th>");
		pw.print("<th>비번</th>");
		pw.print("<th>이름</th>");
		pw.print("<th>이메일</th>");
		pw.print("<th>가입일자</th>");
		pw.print("</tr>");
		for(MemberVO vo : memberList) {
			pw.print("<tr>");
			pw.print("<td>"+vo.getId()+"</td>");
			pw.print("<td>"+vo.getPwd()+"</td>");
			pw.print("<td>"+vo.getName()+"</td>");
			pw.print("<td>"+vo.getEmail()+"</td>");
			pw.print("<td>"+vo.getJoindate()+"</td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
		pw.print("</body>");
		pw.print("</html>");
		
	}

}
