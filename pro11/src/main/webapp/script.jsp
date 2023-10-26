<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>
  <%@ page import="java.util.ArrayList" %>
  
  <%
  
  List<String> list = new ArrayList<>();
	
	list.add("홍길동");
	list.add("김길동");
	list.add("장장");
	
	String name ="hi";
	String email="hong";
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=name %><br>
<%=email %><br>
<%=sum(1,2) %><br>


<table border="1">
<tr>
<th>이름</th>
</tr>
<% for(int i=0; i<list.size(); i++) { %>
<tr class="<%=i%2==0?"a":"b"%>">
	<td><%=list.get(i) %></td>
</tr>
<%} %>
</table>
</body>
</html>

<%!
	
	int sum(int a, int b){
		
		return a+b;
	}
	

%>