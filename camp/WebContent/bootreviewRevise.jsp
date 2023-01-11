<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.ReviewVO,member.MemberVO,bootcamp.BootcampVO,member.MemberDAO,review.ReviewDAO,review.ReviewScoreVO,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정페이지</title>
<style>
	
</style>



<script type="text/javascript">

function stars(num){
	if(num == 5){
		document.write("⭐⭐⭐⭐⭐");
	}else if( num == 4){
		document.write("⭐⭐⭐⭐");
	}else if( num == 3){
		document.write("⭐⭐⭐");
	}else if( num == 2){
		document.write("⭐⭐");
	}else{
		document.write("⭐");
	}
	
}
</script>

</head>

<body> 
	<h2>작성하신 글을 수정해주세요</h2>
		
	<form name="update" action= "review" method="post" >
		<input type="hidden" name="action" value="updateReview">
	<%
		MemberDAO mDao = new MemberDAO();
		ReviewDAO rdao = new ReviewDAO();
		MemberVO mvo = (MemberVO)session.getAttribute("loginVO"); //memberlogin servlet과 연결, loginVO : mDao.getMember((String) session.getAttribute("login.id"))
		int mnum = (int) mvo.getmnum();//현재 로그인 사용자의 mnum을 가져옴 // 이 줄에서 에러 시작해서 rvo 호출이 안되는 중 
		ArrayList<ReviewVO> list = (ArrayList<ReviewVO>) rdao.listOnelist(mnum); //ReviewDAO에서 int 값을 넣어서 ReviewVO 객체를 담은 리스트를 반환받음
		
		for(ReviewVO rvo : list){
			%>
		<div id="nameDate"><%=mDao.getMember(rvo.getM_id()).getnname() %>님의 글 &nbsp;|&nbsp;<%= rvo.getWriteDate()%> </div><!-- 수정날짜로 바꾸는 메서드 -->
		<table class=>
		<tr>
		<td>강사진 만족도</td><td>
				<select name = "teachScore">
				<option value="<%=rvo.getT_score()%>"><script>stars(<%=rvo.getT_score()%>)</script></option>
		          <option value = "5">⭐⭐⭐⭐⭐</option>
		          <option value = "4">⭐⭐⭐⭐</option>
		          <option value = "3">⭐⭐⭐</option>
		          <option value = "2">⭐⭐</option>
		          <option value = "1">⭐</option>
		       </select></td></tr>
		       
				
				<tr><td>학습환경 만족도</td><td>
				<select name = "learnScore">
				<option value="<%=rvo.getE_score()%>"><script>stars(<%=rvo.getE_score()%>)</script></option>
		          <option value = "5">⭐⭐⭐⭐⭐</option>
		          <option value = "4">⭐⭐⭐⭐</option>
		          <option value = "3">⭐⭐⭐</option>
		          <option value = "2">⭐⭐</option>
		          <option value = "1">⭐</option>
		       </select></td></tr>
		       
		       <tr><td>교육지원 수준</td><td>
				<select name = "eduScore">
				<option value="<%=rvo.getS_score()%>"><script>stars(<%=rvo.getS_score()%>)</script></option>
		          <option value = "5" selected>⭐⭐⭐⭐⭐</option>
		          <option value = "4">⭐⭐⭐⭐</option>
		          <option value = "3">⭐⭐⭐</option>
		          <option value = "2">⭐⭐</option>
		          <option value = "1">⭐</option>
		       </select></td></tr>
		       
		       <tr><td>총 평점</td><td>
				<select name = "totalScore">
				<option value="<%=rvo.getScore()%>"><script>stars(<%=rvo.getScore()%>)</script></option>
		          <option value = "5" >⭐⭐⭐⭐⭐</option>
		          <option value = "4">⭐⭐⭐⭐</option>
		          <option value = "3">⭐⭐⭐</option>
		          <option value = "2">⭐⭐</option>
		          <option value = "1">⭐</option>
		        </select></td></tr>
		       
				<tr><td>장점</td><td>
				<input type="text" name="newGood" value="<%=rvo.getGood() %>"><br>
				</td></tr>
			
				<tr><td>단점</td><td>
				<input type="text" name="newBad" value="<%=rvo.getBad() %>">
				</td></tr>
			
			</table>

	
	<% } %>
	<%
		//}else{%>
		<script>
		//alert("작성하신 리뷰가 없습니다");
		
		</script>
		<%// } %>
	<br>	
	<input type="submit"  value="수정 완료">
	<input type="button" value="뒤로가기" onclick="history.back(-1);">
	</form>
<%	
		if (request.getAttribute("msg") != null) { 
		%>
		<script>
		alert('${ msg }');
		</script> 
<% 		} %>
</body>
</html>