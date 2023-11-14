package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public void init() throws ServletException{
    	System.out.println("init 호출");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		String data ="<html> "
				+ "<body>"
				+ "아이디 : " +user_id
				+ "<br>"
				+ "패스워드 : "+user_pw
				+ "</body>"
				+ "</html>";
		out.print(data);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("아이디 : "+request.getParameter("user_id"));
		System.out.println("비밀번호 : "+request.getParameter("user_pw"));
		
	}
	
	
	public void destroy() {
		
		System.out.println("destroy 메서드 호출");
	}

}
