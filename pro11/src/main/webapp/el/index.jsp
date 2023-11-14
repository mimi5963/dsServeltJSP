<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 

	request.setAttribute("name", "홍길동");
	session.setAttribute("email", "hong@gmail.com");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${name }<br>
${sessionScope.email}<br> <!--EL의 장점은 에러가 안남 -->
${member.name2}<br> <!-- member.name에서 name은 getName() 불러줌!! getxxx에 xxx추정해서 사용함
					 .뒤에 적은 이름이랑 get뒤의 메서드명 비교 -->
${map.vo.name}<br> <!-- request에 key로 map이 되어있는 개체 꺼냄, map안에 vo이름의 객체 꺼냄  -->
				   <!-- el은 키를 적으면 값을 꺼내줌  -->
${param.id}
</body>
</html>