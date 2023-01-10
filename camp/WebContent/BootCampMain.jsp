<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="review.ReviewVO,bootcamp.BootcampVO2,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>

<style>
	@font-face {
    font-family: 'SUIT-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_suit@1.0/SUIT-Regular.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
    
}
	
	* {
	font-family:'SUIT-Regular';
	
	}
	
	.bootData{
		border:3px solid #B9B5B5;
		width:250px;
		height:400px;
		border-radius:10px;
		display:inline-block;
		margin:30px;
		
	}
	nav{
	text-align:center;
	}
	img{
		width:250px;
		height:300px;
		
	}
	
	p{
		margin:35px;
	}
	
	h1{
		text-align:center;
	}
	
	
</style>

</head>
<body>
<h1>부트캠프 후기모음 사이트 메인페이지</h1>

	<header>
		<nav>
			<form method="get" action="/camp/bootcamp2"> 
	  		<input type="search" name="keyword" size="15">
	  		<input type="submit" value="검색">
  			</form>
		</nav>
		<button class="login">로그인</button>
		<button onclick="location.href='/camp/goBootcamps' ">부트캠프등록하기</button>	
	</header>


<%

	ArrayList<BootcampVO2> list = (ArrayList<BootcampVO2>)request.getAttribute("list");
	if(list != null){
%>

	<section>
		<article>
		<% for(BootcampVO2 vo : list){%>
			<div class="bootData" onclick="location.href='/camp/goReviews2?bnum=<%=vo.getId()%>'">
			 	<img src =".\images\<%=vo.getRogo() %>" id=<%=vo.getB_name()%> >
			 	<p><%= vo.getB_name() %></p>
			</div>
		<%
		
		} %>
		</article>
	</section>
<%
	}
	if (request.getAttribute("msg") != null) {
%>

	<script>
		alert('${ msg }');
	</script>

<%
	}
%>
</body>
</html>