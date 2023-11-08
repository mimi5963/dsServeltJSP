<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록창</title>
<style>
	.cls1 {
		text-decoration: none;
	}
	.cls2 {
		font-size:30px;
		text-align:center;
	}
</style>
</head>
<body>

<table align="center" border="1" width="80%">
	<tr hight="10" align="center" bgcolor="lightgreen">
		<td><b>글번호</b></td>
		<td><b>작성자</b></td>
		<td><b>제목</b></td>
		<td><b>작성일</b></td>
	</tr>
	
	<c:if test="${empty articlesList }">
	<tr height="10">
		<td colspan="4">
			<b>등록된 글이 없습니다.</b>
		</td>
	</tr>
	</c:if>
	<c:forEach var="article" items="${articlesList }" varStatus="articleNum">
	<tr align="center">
		<td width="5%">${articleNum.count }</td>
		<td width="10%">${article.id }</td>
		<td align="left" width="35%">
			<span style="padding-right: 5px"></span>
			<c:forEach begin="1" end="${article.nested}">
				<span style="padding-right:20px"></span> <!-- 본인의 depth만큼 옆으로 치우려고 -->
			</c:forEach>
			<a class="cls1" href="viewArticle.do?articleno=${article.articleno}">
			${article.title}
			</a>
		
		</td>
		<td width="10%">${article.writeDate }</td>
	</tr>
	</c:forEach>
	
</table>
<a href="/pro17/board/articleForm.do" style="text-align: center;"><p>글쓰기</p></a>
</body>
</html>