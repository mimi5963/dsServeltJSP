<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"
    import="sec02.ex01.*"
    import="test.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	session.setAttribute("loginInfo", "홍길동");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="name" value="홍길동"/>
${name}<br>
<!-- 파라미터 id가 hong이면 안녕하세요 출력 -->
<c:if test="${param.id == 'hong'}"> <!-- ""안에서 적는거라 무조건 ''하셈 문자열 -->
안녕하세요
</c:if>
<c:if test="${param.id != 'hong'}">
안녕히가셔유
</c:if>
<c:if test="${empty loginInfo}">
<button>로그인</button>
</c:if>

<c:if test="${!empty loginInfo}">
<button>로그아웃</button>
<% session.setMaxInactiveInterval(0); %>
</c:if>
<c:set var="age" value="5"/>
<c:choose>
<c:when test="${age >= 20 && age < 30}">20대</c:when>
<c:when test="${age >= 30 && age < 40}">30대</c:when>
<c:otherwise>기타</c:otherwise>
</c:choose>
<c:forEach var="i" begin="1" end="10">
${i}
</c:forEach>

<%
	List<MemberVO> list = new ArrayList<>();
	MemberVO vo = new MemberVO();
	vo.setName("홍길동");
	list.add(vo);
	
	vo = new MemberVO();
	vo.setName("김길동");
	list.add(vo);
	
	request.setAttribute("list", list);
	request.setAttribute("price", 10000);
	request.setAttribute("date",new Date());
%>
<c:forEach var="mvo" items="${list}">
${mvo.name}
</c:forEach>
<img src="<c:url value="/img/google.png"/>">

금액 : <fmt:formatNumber value="${price}"/>
일자 : <fmt:formatDate value="${date}" pattern="YYYY-MM-dd hh:mm:ss"/>

<% request.setAttribute("test", new test.Test()); %>

${test.oneToNSum(10)}
${Test.checkDate()} 
</body>
</html>