<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script type="text/javascript">
function readURL(input) {
	if(input.files && input.files[0]){
		var render = new FileReader();
		render.onload = function(e){
			$("#preview").attr('src',e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
	
}
function backToList(obj) {
	obj.action = "${contextPath}/board/listArticles.do";
	obj.submit();
}

function modify(){
	
	location.href = "modArticleForm.do?articleno=${article.articleno}";
}
</script>

</head>
<body>

<h1 style="text-align: center;">글 상세</h1>

<table align="center">

<tr>
<td width="20%" align="center" bgcolor="#FF9933">글제목: </td>
<td >${article.title}</td>
</tr>

<tr>
<td width="20%" align="center" bgcolor="#FF9933">글내용: </td>
<td>${article.content}</td>
</tr>

<c:if test="${!empty article.imageFileName}">
<tr>
<td width="20%" align="center" bgcolor="#FF9933">이미지</td>
<td><img src="/pro17/download.do?path=/article_image&fileName=${article.imageFileName}"></td>
</tr>
</c:if>


<tr>
<td width="20%" align="center" bgcolor="#FF9933">등록일자</td>
<td>${article.writeDate}</td>
</tr>

<tr>
<td width="20%" align="center" bgcolor="#FF9933">글번호: </td>
<td >${article.articleno}</td>
</tr>

<tr>
<td width="20%" align="center" bgcolor="#FF9933">아이디: </td>
<td >${article.id}</td>
</tr>

<tr>
	<td colspan="2" align="center">
	<input type="button" value="수정하기" onclick="modify();">
	<input type="button" value="삭제하기">
	<input type="button" value="목록보기" onclick="location.href='listArticles.do';">
	<input type="button" value="답글쓰기">
	</td>

</tr>

</table>




</body>
</html>