<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import = "java.util.ArrayList, member.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//session에서 아이디 값을 가지고 옴
	String id = (String) session.getAttribute("id");
	if(id ==null){
		alert("로그인 후 회원정보 조회가 가능합니다");
		response.sendRedirect("MemberDesign.html"); //만약 로그인된 상태가 아니라면 로그인 창으로 이동
	}

</script>
</head>
<body>
<%
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
	if(list != null){
%>
	<h2>회원정보 조회</h2><hr>
	<table>
<%
		for(MemberVO vo : list){
%>
			<tr>
			<td>아이디</td>
			<td><%=vo.getid() %></td>
			<td>비밀번호</td>
			<td><%=vo.getpwd() %></td>
			<td>이름</td>
			<td><%=vo.getname() %></td>
			<td>이메일</td>
			<td><%=vo.getemail() %></td>
			<td>전화번호</td>
			<td><%=vo.getpnum() %></td>
			<td>닉네임</td>
			<td><%=vo.getnname() %></td>
			</tr>
<%
		}
	}
%>
	</table>
</body>
</html>