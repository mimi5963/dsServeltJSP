package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.RoomVO;

/**
 * Servlet implementation class UpdateRoom
 */

@WebServlet("/up")
public class UpdateRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/updateRoom.do").forward(request, response);
	        
	}

}
