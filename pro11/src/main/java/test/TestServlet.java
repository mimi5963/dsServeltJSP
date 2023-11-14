package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec02.ex01.MemberVO;


@WebServlet("/el")
public class TestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("name", "홍길동");
		request.getSession().setAttribute("name", "hong@navaer.ccc");
		
		
		MemberVO member = new MemberVO();
		member.setName("홍길동이래유");
		request.setAttribute("member", member);
		Map map = new HashMap();
		map.put("vo", member);
		request.setAttribute("map", map);
		request.getRequestDispatcher("/el/index.jsp").forward(request, response);
		
		
	}

	

}
