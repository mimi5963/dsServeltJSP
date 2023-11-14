package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.RoomVO;

public class UpdateRoomController implements Controller {
    
    Set<RoomVO> set = new HashSet<>();
    
    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("요청들어옴");
        String name = request.getParameter("roomname");
        String mode = request.getParameter("mode");
        
        ServletContext sc = request.getServletContext();
        
        RoomVO vo = new RoomVO();
        vo.setName(name);
        vo.setMode(mode);
        vo.setOwner("kang");        
        set.add(vo);
        
      
//      HttpSession sess = request.getSession();
        request.setAttribute("hi", "hi");
        sc.setAttribute("roomSet", set);
        System.out.println(name);
        System.out.println(mode);
        
        response.getWriter().print(name+mode);
        
        return "wroom";
    }

}
