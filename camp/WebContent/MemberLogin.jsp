<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 </title>
<style type="text/css">
#login_main{
	display: inline-block;
	text-align: center;
}

</style>
<div id="login_main">
	<h2>로그인</h2><hr>
	<form method="post" action="login">
		<input type="hidden" name="action" value="login">  
		<input placeholder="아이디를 입력하세요" name="id"><br>
		<input type="pwd" placeholder="패스워드를 입력하세요" name="pwd"><br>
		<input type="submit" value="로그인">
	</form>
</div>
</body>
</html>
