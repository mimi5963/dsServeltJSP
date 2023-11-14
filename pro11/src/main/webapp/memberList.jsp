<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %> <!-- 인클루드할 때 에러나면 여기가 같아야함 페이지 지시어 틀리면 에러남 -->
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.memberD:nth-child(even) {
		background-color: white;
	}
.memberD:nth-child(odd) {
	background-color: gray;
}
</style>
</head>
<body>

<h1>회원목록</h1>
<form action="member.do" method="get">
이름 : <input type="text" name="searchWord" value="${param.name}"><br>
<input type="submit" value="조회하기">
</form>


<table border="1" width="800" align="center">
<tr align="center" bgcolor="#FFFF66">
	<td>아이디</td>
	<td>비번</td>
	<td>이름</td>
	<td>이메일</td>
	<td>가입일자</td>
</tr>
<c:forEach var="member" items="${list}" >
<tr class="memberD">
<td>${member.id}</td>
<td>${member.pwd}</td>
<td>${member.name}</td>
<td>${member.email}</td>
<td>${member.joindate}</td>
</tr>
</c:forEach>

</table>

</body>
</html>