<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
 
String name = "홍길동";
 
 %>  
 <h1>여기는 b.jsp</h1>
 <%=name%>
 <%=request.getAttribute("name")%>
 