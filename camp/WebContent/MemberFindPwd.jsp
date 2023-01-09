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
	String findId = (String)request.getAttribute("findId");
%>

	<!-- 새 비밀번호 설정창 -->
	<form method="post" action="login">
		<input type="hidden" name="action" value="updatePwd">
		<input type="hidden" name="findId" value=<%= findId %>><!-- 나중에 값 숨겨줘야됨 -->
		<input type="password" placeholder="새 비밀번호를 입력하세요." name="newPwd" required><br>
		<input type="password" placeholder="새 비밀번호 확인" name="checkNewPwd" required><br>
		<input type="submit" class="button" value="전송">
	</form>

</body>
</html>
