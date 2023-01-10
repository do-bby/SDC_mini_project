<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.ReviewVO,member.MemberVO,bootcamp.BootcampVO,member.MemberDAO,review.ReviewDAO,review.ReviewScoreVO,java.util.ArrayList"%>
<%@ page import="java.lang.IndexOutOfBoundsException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 조회</title>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDy81EbO46BRSnX1DOgg_F84bhsdbku2z4"></script>
<style type="text/css">
	@font-face {
    font-family: 'SUIT-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_suit@1.0/SUIT-Regular.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
    
}
	
	* {
	font-family:'SUIT-Regular';
	
	}
	
	header {
		width : 850px;
		height : 100px;
		margin:auto;
	}
	
	nav{
		margin-right:0px;
		position:relative;
		left:550px;
	}
	
	#section1 {
		margin:auto;
		width:880px;
	}
	
	#section2,#section3 {
	
		border-color:#B9B5B5;
		border-width:3px;
		border-style:solid;
		margin:20px auto;
		width:830px; 
		border-radius:10px;
		
	}
	

	
	article{
		margin : 20px;
	}

	.topBtn{
		box-shadow:inset 0px -3px 7px -36px #29bbff;
		background:linear-gradient(to bottom, #95cff0 5%, #058fff 100%);
		background-color:#95cff0;
		border-radius:3px;
		border:1px solid #0b0e07;
		display:inline-block;
		cursor:pointer;
		color:#ffffff;
		padding:4px 18px;
		text-decoration:none;
		text-shadow:0px 0px 0px #365dd1;
	
	}
	
	.topBtn:hover {
		background:linear-gradient(to bottom, #058fff 5%, #95cff0 100%);
		background-color:#058fff;
	}
	.topBtn:active {
		position:relative;
		top:1px;
	}
	
	.BtnReview{
		box-shadow:inset 0px -3px 7px -36px #29bbff;
		background:linear-gradient(to bottom, #95cff0 5%, #058fff 100%);
		background-color:#95cff0;
		border-radius:3px;
		border:1px solid #0b0e07;
		display:inline-block;
		cursor:pointer;
		color:#ffffff;
		padding:4px 18px;
		text-decoration:none;
		text-shadow:0px 0px 0px #365dd1;
	
	}
	

	.BtnReview:hover {
		background:linear-gradient(to bottom, #058fff 5%, #95cff0 100%);
		background-color:#058fff;
	}
	.BtnReview:active {
		position:relative;
		top:1px;
	}
	
	#academyLogo{
		border:3px solid #B9B5B5;
		position:absolute;
		z-index:2;
		bottom:0px;
		left:20px;
		border-radius:10px;
	}
	
	#bootLogo{
		position:absolute;
		z-index:1;
		border-radius:10px;
	}
	
	#aname{
		position:absolute;
		z-index:2;
		left:150px;
		bottom:0px;
		background-color:#BCD8FB;
		border-radius:5px;
		padding:5px;
		margin:0px;
		
	}
	
	#logoBox{
	position:relative;
	width: 100%;
	height: 350px;	
	top:20px;
	}

	#wrap{
		width:100%;
		margin:0,auto;
	}
	
	#BtnInsertReview{
		position:relative;
		left:400px;
	
	}
	
	.mapAndScore{
		display:inline-block;
	}
	.star{
		
    	display: inline-block;
	}
	
	.reviewBox{
		border-color:#B9B5B5;
		border-width:3px;
		border-style:solid;
		height:80px;
		padding:10px;
		border-radius:10px;
		position:relative;
	}
	
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
	}
	
	#websiteLogo{
		position:relative;
		width:450px;
		top:45px;
	}
	
	.BtnReview {
		box-shadow:inset 0px -3px 7px -36px #29bbff;
		background:linear-gradient(to bottom, #95cff0 5%, #058fff 100%);
		background-color:#95cff0;
		border-radius:3px;
		border:1px solid #0b0e07;
		display:inline-block;
		cursor:pointer;
		color:#ffffff;
		padding:10px 30px;
		text-decoration:none;
		text-shadow:0px 0px 0px #365dd1;
		margin-left:298px;
	}
	
	#nameDate{
		position:relative;
		display:inline-block;
		bottom:30px;
		left:20px;
	}
	
	.score{
		position:relative;
		margin:20px;
	
	}

	
</style>


</head>

<body>


<div id="wrap">
	<header>
		<a href ='/camp/goReviews'><img id="websiteLogo" src=".\images\부트모아로고3.png" ></a>
		
		<nav> 
		
			<%	
				MemberVO mvo = (MemberVO)session.getAttribute("loginVO");
				if(session.getAttribute("isLogOn") != null ){
					
			%>
					<span><%= mvo.getnname() %>님 환영합니다 </span>
					<form style="display:inline-block;" method="post" action="login">
						<input type="hidden" name="action" value="logout">
						<button type="submit" class="topBtn" value="전송">로그아웃</button>
					</form>
			<%
				}else{
			%>
					<form method="post" action="login">
						<input type="hidden" name="action" value="login">
						<button type="submit" class="topBtn" value="전송">로그인</button>
					</form>
					
			<%
				}
			%>
			
		</nav>
	</header>
	
	<section id="section1">
	<%
	BootcampVO bvo = (BootcampVO)request.getAttribute("bvo");
	
	if(bvo != null){
		
	%>
		<article id="logoBox">
			<img id="bootLogo" src=".\images\<%=bvo.getRealimg() %>" width=830px; height=300px;>
			<a href=<%=bvo.getSite() %>><img id="academyLogo" src=".\images\<%=bvo.getRogo() %>" width=100px; height=100px;></a>
			<h3 id="aname"><%= bvo.getA_name() %> - <%= bvo.getB_name()%></h3>
		</article>		
	<%
	}
	%>		
		
		
		<article>
			<div id="BtnInsertReview">
				<button class="BtnReview" onclick="loginAlert(<%=bvo.getId()%>,<%=session.getAttribute("isLogOn")%>)">리뷰 등록하기</button>
			</div>
		</article>
		
		
	</section>
	
	<section id="section2">
		<article class="mapAndScore">
		<div id="map" style="width:300px; height:200px;"></div>
		</article>
		
	<% 	// goReviewServlet에서 넘겨준 특정 부트캠프에 대한 리뷰들
	
		ArrayList<ReviewVO> reviewList = (ArrayList<ReviewVO>)request.getAttribute("reviewList");
		ReviewDAO rDao = new ReviewDAO();
		//ArrayList<ReviewVO> scoreList = rDao.sumScoreList();
		ArrayList<ReviewScoreVO> scoreList = (ArrayList<ReviewScoreVO>)rDao.sumScoreList();
		try{
			if (request.getAttribute("bnum") != null){
				
				int bnum = (int)request.getAttribute("bnum");

		
		%>			
				<article class="mapAndScore">
					<p><span class="star" style="width:100%;">평균 만족도</span></p>
					<p><span class="star" style="width:100%;">강사진 만족도<%= scoreList.get(bnum-1).getT_score() %></span></p>
					<p><span class="star" style="width:100%;">학습환경 만족도<%= scoreList.get(bnum-1).getE_score() %></span></p>
					<p><span class="star" style="width:100%;">교육지원 만족도<%= scoreList.get(bnum-1).getS_score() %></span></p>
					<p><span class="star" style="width:100%;">총점<%=scoreList.get(bnum-1).getScore() %></span></p>
					
				</article>
				<%
			}
				%>
		<%
		}catch(IndexOutOfBoundsException e){
	%>
			
	<%
		}
	%>
	</section>
	
	<section id="section3"">
	
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
	<%
	
	MemberDAO mDao = new MemberDAO();
	if (reviewList.size() != 0){
		
	%>
<% 	
		for(ReviewVO rvo : reviewList){
%>
			<article>
				
				<div id="reviewBox"> 
					<div id="reviewBox1">
					<img src=".\images\기본프로필사진.png" style="border-radius:70%;" width="70px;" height="70px;">
					<div id="nameDate"><%= mDao.getMember(rvo.getM_id()).getnname() %>|<%= rvo.getWriteDate()%> </div>
					<div class = score>강사진 만족도 <script>stars(<%=rvo.getT_score()%>)</script></div>
					<div class = score>학습환경 만족도<script>stars(<%=rvo.getE_score() %>)</script></div>
					<div class = score>교육지원 수준<script>stars(<%=rvo.getS_score() %>)</script></div>
					</div>
					<div id="reviewBox2">
					<span style="color:red;">장점</span>
					<div class="reviewBox"><%=rvo.getGood() %></div>
					<span class="text" style="color:blue">단점</span>
					<div class="reviewBox"><%=rvo.getBad() %></div>
					</div>
				</div>
			</article>
<%
		}
%>
	<%
	}else{	
	%>
		<article>
			<div id="reviewBox">
				<h1 style="margin-left:250px;margin-top:100px;">등록된 리뷰가 없습니다😭</h1>
			</div>
		</article>
	<%
	}
	%>		
				
	</section>
	<script type="text/javascript">
	
		// id가 map인 dom 객체를 가져와 저장하고 그 부분에 지도를 출력하도록 함
    	const dom = document.getElementById("map");
    	url= 'https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyDy81EbO46BRSnX1DOgg_F84bhsdbku2z4&address='+'<%=bvo.getAddress()%>'
		
    	var request = new XMLHttpRequest();
		request.onload = function(event) {
			if (request.status == 200) {
				var obj = JSON.parse(request.responseText);
				lat = obj.results[0].geometry.location.lat;
				lng = obj.results[0].geometry.location.lng;
				dom.innerHTML = '';
				googleMap(lat, lng);
			}
		};
		
		request.open('GET', url, true);
		request.send();
	
		// 위도와 경도를 매개변수로 받아 지도를 생성
		function googleMap(latp,lngp){
			var latlng = {lat:latp,lng:lngp}
			var map = new google.maps.Map(dom,{
				center:latlng,
				zoom: 18
			})
			
			// 마커 생성
			new google.maps.Marker({position: latlng, map:map})
		};
		
		
		// 로그인 되어있으면 리뷰 작성페이지로, 로그인 되어있지 않으면 로그인 페이지로 이동
		function loginAlert(bnum,loginCheck){ // 특정 부트캠프의 id값 = bnum을 매개변수로 받아들임
			
			if(loginCheck == null){
				alert("로그인 후 리뷰 작성이 가능합니다.");
				location.href='/camp/login';
			}else{
				
				location.href='/camp/review?bnum='+bnum;
			}
			
		};
		
		
</script>
	
</div>	
</body>

</html>