<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
매개변수1 : ${param.param1 }<br>
<c:if test="${!empty param.param1 }">
	<img src="/pro15/download.do?fileName=${param.param1 }" width=300 height=300><br>
	<img src="/pro15/upload/${param.param1 }" width=300 height=300><br>
</c:if>
<br>
파일 내려받기 : <br>
<a href="/pro15/download.do?fileName=${param.param1 }">파일 내려받기</a>
</body>
</html>

<c:forEach items="" var="">
</c:forEach>