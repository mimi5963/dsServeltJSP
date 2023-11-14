package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public void init() throws ServletException{
    	System.out.println("input servlet init 호출");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		Enumeration<String> enu = request.getParameterNames();
		
		enu.asIterator().forEachRemaining(e -> {
			System.out.println("name = " + e);
			String[] values = request.getParameterValues(e);
			for(String v : values) {
				System.out.println("name = "+e);
				System.out.println("value = "+v);
			}
			
		});
		
		
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("아이디 : "+request.getParameter("user_id"));
		System.out.println("비밀번호 : "+request.getParameter("user_pw"));
		String[] results = request.getParameterValues("subject");
		
	}
	
	
	public void destroy() {
		
		System.out.println("input servlet destroy 메서드 호출");
	}

}
