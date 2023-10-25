package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(urlPatterns = {"/initMenu","/menu"}, 
//initParams = {
//		@WebInitParam(name="menu_member",value = "admin@jweb.com")
//})
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
   public void init(ServletConfig config) throws ServletException {
	   System.out.println("init 호출");
	   String path = config.getInitParameter("configuration");
	   System.out.println(path+"여기서호출");
	
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		//request에서 꺼내써야함.. init메서드를 을 추가하면
		ServletContext ctx = request.getServletContext();
//		ServletContext ctx = getServletContext(); //왜 못불러와....
		String menu_member = ctx.getInitParameter("menu_member");
		String menu_order = ctx.getInitParameter("menu_order");
		String menu_goods = ctx.getInitParameter("menu_goods");

		//		String path = getInitParameter("configuration");
		//		System.out.println(path);
		pw.print("<table border=1 cellspcing=0><tr>메뉴 이름</tr>");
		pw.print("<tr><td>"+menu_member+"</td></tr>");
		pw.print("<tr><td>"+menu_order+"</td></tr>");
		pw.print("<tr><td>"+menu_goods+"</td></tr>");
	}

}
