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
<form action="<c:url value='/member/modMember.do'/>" method="post">
<input type="hidden" name="id" value="${memInfo.id}">
<h1 style="text-align: center;">회원 정보 수정창</h1>
<table align="center">
<tr>
<td width="200"><p align="right">아이디</p></td>
<td width="400">${memInfo.id}</td>
</tr>
<tr>
<td width="200"><p align="right">비밀번호</p></td>
<td width="400"><input type="password" name="pwd" value="${memInfo.pwd}"></td>
</tr>
<tr>
<td width="200"><p align="right">이름</p></td>
<td width="400"><input type="text" name="name" value="${memInfo.name}"></td>
</tr>
<tr>
<td width="200"><p align="right">이메일</p></td>
<td width="400"><input type="text" name="email" value="${memInfo.email}"></td>
</tr>
<tr>
<td width="200"><p align="right">가입일</p></td>
<td width="400">${memInfo.joindate}</td>
</tr>
<tr>
<td width="200"><p>&nbsp;</p></td>
<td width="400">
<input type="submit" value="수정하기">
<input type="reset" value="다시입력">
</td>

</tr>

</table>


</form>
</body>
</html>