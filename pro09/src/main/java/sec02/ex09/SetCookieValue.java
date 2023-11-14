package sec02.ex09;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		Date d = new Date();
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP프로그매밍힙니다","utf-8"));
		
		c.setMaxAge(24*60*60);
		response.addCookie(c);
		
		pw.print("현재시간 : " +d);
		pw.print("문자열을 cookie에 저장합니다");
		
		//세션생성
		HttpSession s = request.getSession();
		
		//저장
		s.setAttribute("name", "김길동");
		
		Map map = new HashMap();
		map.put("id", "hong");
		map.put("name", "홍길동");
		map.put("eamil", "hong@");
		s.setAttribute("loginInfo", map);
		
		
		
	}

}
