package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final float USD_RATE = 1353f;
	private static final float JPY_RATE = 902.54f;
	private static final float CNY_RATE = 184.71f;
	private static final float GBP_RATE = 1646.06f;
	private static final float EUR_RATE = 1432.15f;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		System.out.println(command);
		System.out.println(won);
		System.out.println(operator);
		if(command != null && command.equals("calculate")) {
			System.out.println("여기옴");
			String result = calculate(Float.parseFloat(won),operator);
			out.print("<html><font size=10>변환결과</font><br>");
			out.print("<html><font size=10>"+result+"</font><br>");
			out.print("<a href='/pro06/calc'>환율계산기</a>");
			return;
		}
		
		String data="<html><title>환율계산기</title>"
				+ "<font size=5>환율계산기</font><br>"
				+ "<form name='frmCalc' method='get' action='/pro06/calc'/>"
				+ "원화: <input type='text' name='won' size=10 />"
				+"<select name ='operator'>"
				+"<option value='dollar'> 달러 </option>"
				+ "<option value='en'> 앤화 </option>"
				+ "<option value='wian'> 위안 </option>"
				+ "<option value='pound'> 파운드 </option>"
				+ "<option value='euro'> 유로</option>"
				+"</select>"
				+"<input type='hidden' name='command' value='calculate'>"
				+"<input type='submit' value='변환' />"
				+"</form>"
				+"</html>";
		out.print(data);
		out.close();
	
	
	}

	
	private String calculate(float won, String operator) {
		String result = null;
		
		if(operator.equals("dollar")){
			result = String.format("%.6f", won/USD_RATE);
		}else if(operator.equals("en")){
			result = String.format("%.6f", won/JPY_RATE);
		}else if(operator.equals("wian")) {
			result = String.format("%.6f", won/CNY_RATE);
		}else if(operator.equals("pound")) {
			result = String.format("%.6f", won/GBP_RATE);
		}else if(operator.equals("euro")) {
			result = String.format("%.6f", won/EUR_RATE);
		}
		System.out.println(result);
		return result;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
