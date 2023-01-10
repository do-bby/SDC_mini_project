<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="review.ReviewVO,member.MemberVO,bootcamp.BootcampVO,java.util.ArrayList"%>
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
<%
	//boolean loginCheck = (boolean)session.getAttribute("isLogOn");
	MemberVO mvo = (MemberVO)session.getAttribute("loginVO");
	if(session.getAttribute("isLogOn") != null){ //로그인 해서 세션이 생성되면 환영 문구 띄움
%>
		<h1><%=mvo.getnname()%>님 환영합니다 ㅎㅎ</h1>
		<button type="button" onclick="location.href='MemberInfo.jsp'">회원정보 조회/수정</button>
		
<%
	}

%>

<%
	ArrayList<BootcampVO> list = (ArrayList<BootcampVO>)request.getAttribute("list");
	if(list != null){
%>
	<section>
		<article>
		<% for(BootcampVO bvo : list){%>
			<div class="bootData" onclick="location.href='/camp/goReviews?bnum=<%=bvo.getId()%>'">
			 	<img src =".\images\<%=bvo.getRogo() %>" id=<%=bvo.getB_name()%> >
			 	<p><%= bvo.getB_name() %></p>
			</div>
		<%
		
		} %>
		</article>
	</section>
<%
	}
%>

</body>
</html>