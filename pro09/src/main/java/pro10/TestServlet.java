package pro10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first/*")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("컨텍스트 패스: " + request.getContextPath()+"<br>");
		out.print("URL: "+request.getRequestURL().toString()+"<br>");
		out.print("URI:"+request.getRequestURI()+"<br>");
		out.print("쿼리스트링:"+request.getQueryString()+"<br>");
		out.print("실제경로:"+request.getRealPath("/")+"<br>");
		out.print("누구냐:"+request.getRemoteHost());
	}

}
