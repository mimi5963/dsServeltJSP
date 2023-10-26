<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="sec02.ex01.*"
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
h1{
	text-align: center;
}
</style>

</head>

<body>
<h1>회원 정보 출력</h1>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
MemberVO member = new MemberVO();
member.setName(name);
MemberDAO dao = new MemberDAO();
List<MemberVO> memberList = dao.listMembers(member);

%>

<table border="1" width="800" align="center">
<tr align="center" bgcolor="#FFFF66">
	<td>아이디</td>
	<td>비번</td>
	<td>이름</td>
	<td>이메일</td>
	<td>가입일자</td>
</tr>
<%
for(int i=0; i<memberList.size();i++){
	
	MemberVO vo = memberList.get(i);
	String id = vo.getId();
	String pw = vo.getPwd();
	String _name = vo.getName();
	String email = vo.getEmail();
	Date joinDate = vo.getJoindate();
%>
<tr align="center">
<td><%=id %></td>
<td><%=pw %></td>
<td><%=_name %></td>
<td><%=email %></td>
<td><%=joinDate %></td>
</tr>

<%
} 
%>


</table>
</body>
</html>