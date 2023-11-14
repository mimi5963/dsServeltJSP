package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public void init() throws ServletException{
    	System.out.println("input servlet init 호출");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("아이디 " + user_id);
		System.out.println("비번 "+user_pw);
		String[] results = request.getParameterValues("subject");
		if(results != null){
		for(String checkBox : results) {
			System.out.println(checkBox);
		}
		}
		StringBuilder sb = new StringBuilder();
		
		
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
