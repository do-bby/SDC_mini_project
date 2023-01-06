<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 </title>
<style type="text/css">
#find_pwd{
	display: inline-block;
	text-align: center;
}

</style>
<div id="find_pwd">
	<h2>비밀번호 찾기</h2><hr>
	<form method="post" action="login">
		<input type="hidden" name="action" value="findpwd">  
		<input placeholder="가입하신 이메일을 입력하세요" name="id"><br>
		<input type="submit" class="button" value="전송">
	</form>
</div>

</body>
</html>
