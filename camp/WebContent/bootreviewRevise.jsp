<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.ReviewVO,member.MemberVO,bootcamp.BootcampVO,member.MemberDAO,review.ReviewDAO,review.ReviewScoreVO,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정페이지</title>
<style>
	#reviewBox{
		border-color:#B9B5B5;
		border-width:3px;
		border-style:solid;
		border-radius:10px;
		height:280px;
		width:750px;
		margin:30px auto;
		
		
	}
	
	#reviewBox1{
		float:left;
		position:relative;
		top:20px;
		left:30px;
		width:300px;
		height:250px;
	}
	
	#reviewBox2{
	 	width:400px;
	 	position:relative;
	 	left:20px;
	 	top:5px;
	 	float:left;
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
	<form name="update" method="post" action="updateReview">
	<% 	
	MemberDAO mDao = new MemberDAO();
	ReviewDAO rdao = new ReviewDAO();
	MemberVO mvo = (MemberVO)session.getAttribute("loginVO");
	ReviewVO rvo = (ReviewVO) rdao.listOne(mvo.getmnum()); //현재 로그인한 회원의 리뷰를 가져옴
	if(rvo != null){

%>
	<div id="reviewBox"> 
		<div id="reviewBox1">
		<div id="nameDate"><%= mDao.getMember(rvo.getM_id()).getnname() %>|<%= rvo.getWriteDate()%> </div><!-- 수정날짜로 바꾸는 메서드 -->
		<div class="reviews">강사진 만족도<br><br>
				<select name = "teachScore">
				<option value="<%=rvo.getT_score()%>">stars(<%=rvo.getT_score()%>)</option>
		          <option value = "5">⭐⭐⭐⭐⭐</option>
		          <option value = "4">⭐⭐⭐⭐</option>
		          <option value = "3">⭐⭐⭐</option>
		          <option value = "2">⭐⭐</option>
		          <option value = "1">⭐</option>
		       </select>
				</div>
				<div class="reviews">학습환경 만족도<br><br>
				<select name = "learnScore">
				<option value="<%=rvo.getE_score()%>">stars(<%=rvo.getE_score()%>)</option>
		          <option value = "5">⭐⭐⭐⭐⭐</option>
		          <option value = "4">⭐⭐⭐⭐</option>
		          <option value = "3">⭐⭐⭐</option>
		          <option value = "2">⭐⭐</option>
		          <option value = "1">⭐</option>
		       </select>
		       </div>
				<div class="reviews">교육지원 수준<br><br>
				<select name = "eduScore">
				<option value="<%=rvo.getS_score()%>">stars(<%=rvo.getS_score()%>)</option>
		          <option value = "5" selected>⭐⭐⭐⭐⭐</option>
		          <option value = "4">⭐⭐⭐⭐</option>
		          <option value = "3">⭐⭐⭐</option>
		          <option value = "2">⭐⭐</option>
		          <option value = "1">⭐</option>
		       </select>
		       </div>
				<div class="reviews">총 평점<br><br>
				<select name = "totalScore">
				<option value="<%=rvo.getScore()%>">stars(<%=rvo.getScore()%>)</option>
		          <option value = "5" >⭐⭐⭐⭐⭐</option>
		          <option value = "4">⭐⭐⭐⭐</option>
		          <option value = "3">⭐⭐⭐</option>
		          <option value = "2">⭐⭐</option>
		          <option value = "1">⭐</option>
		       </select>
		       </div>
		</div>
		<div id="reviewBox2">
		<span style="color:red;">장점</span>
		<div class="reviewBox"><%=rvo.getGood() %></div>
		<input type="text" name="newGood" value="<%=rvo.getGood() %>">
		<span class="text" style="color:blue">단점</span>
		<input type="text" name="newBad" value="<%=rvo.getBad() %>">
		</div>
	</div>
	<%
		}else{%>
		<script>
		alert("작성하신 리뷰가 없습니다");
		
		</script>
		<% } %>
		
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