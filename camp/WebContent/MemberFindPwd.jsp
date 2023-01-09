<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "member.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 </title>
<style type="text/css">
#find_pwd{
	display: inline-block;
	text-align: center;
	background-color: green;
}

</style>
<body>
<%
	String findPwd = (String)request.getAttribute("findPwd");
%>

<a> 비밀번호는 <%= findPwd %> 입니다.</a>

</body>
</html>
