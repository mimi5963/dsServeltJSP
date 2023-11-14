package sec02.ex09;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		Cookie[] allCookie = request.getCookies();
		
		Arrays.stream(allCookie).filter(cookie -> {
			return "cookieTest".equals(cookie.getName());
		}).forEach(cookie -> {
			try {
				pw.print("<h2> Cookie 값 가져오기 : "+URLDecoder.decode(cookie.getValue(),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}
		});
		
		HttpSession ses = request.getSession();
		String name =(String)ses.getAttribute("name");
		System.out.println("세션 출력");
		System.out.println(name);
		
		Map logininfo = (Map)ses.getAttribute("loginInfo");
		System.out.println(logininfo.get("id"));
		
		
	}

}
