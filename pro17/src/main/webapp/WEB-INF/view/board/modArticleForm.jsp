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
		render.readAsDataURL(input.files[0]);
	}
	
}
function backToList(obj) {
	obj.action = "${contextPath}/board/listArticles.do";
	obj.submit();
}

</script>

</head>
<body>


<form name="articleForm" action="<c:url value='/board/modArticle.do'/>" method="post" enctype="multipart/form-data">
<h1 style="text-align: center;">글 수정하기</h1>
<input type="hidden" name="articleno"value="${article.articleno}">
<table border="0" align="center">
<tr>
<td align="right">글제목: </td>
<td colspan="2"><input type="text" size="67", maxlength="500" name="title" value="${article.title}"> </td>
</tr>

<tr>
<td align="right">글내용: </td>
<td colspan="2"><textarea rows="10" cols="65" name="content" maxlength="4000">${article.content}</textarea></td>
</tr>

<tr>
<td align="right">이미지파일 첨부: </td>
<td><input type="file" name="imageFileName" onchange="readURL(this)"> </td>
<td><img id="preview" src="/pro17/download.do?path=article_image&filename=${article.imageFileName}" width="200" height="200"></td>
</tr>

<tr>
<td align="right"></td>
<td colspan="2">
<input type="submit" value="글씨기">
<input type="button" value="목록보기" onclick="backToList(this.form)"/>
</td>
</tr>


</table>

</form>


</body>
</html>