<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 String name = "김길동";
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
여기는 a.jsp
<!-- 인클루드는 그냥 긁어옴 변수명 겹치면 안됨  -> 긁어와서 실행이기 때문에!!!-->
<%//@include file="b.jsp" %>
<%=name%>



<jsp:include page="b.jsp">
<jsp:param value="eeee" name="email"/>
</jsp:include>

<!-- 액션태그는 jsp를 실행한 결과를 가져옴 실행전에 파라미터를 전달할 수 있음, 변수명 겹쳐도 상관 없음 어차피 다 실행해서 옴-->
</body>
</html>