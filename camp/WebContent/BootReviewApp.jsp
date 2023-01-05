<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BootCamp Review App</title>

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
		left:600px;
	}
	
	#section1 {
		margin:auto;
		width:880px;
	}
	
	#section2 {
	
		border-color:#B9B5B5;
		border-width:3px;
		border-style:solid;
		margin:auto;
		width:830px; 
		border-radius:10px;
	}
	
	
	
	article{
		margin : 20px;
	}
	
	textarea{
		border-color:#B9B5B5;
		border-width:3px;
		border-style:solid;
		border-radius:10px;
	}
	
	
	
	div{
		display:inline-block;
	}
	
	.login{
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
	
	.login:hover {
		background:linear-gradient(to bottom, #058fff 5%, #95cff0 100%);
		background-color:#058fff;
	}
	.login:active {
		position:relative;
		top:1px;
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
		padding:4px 18px;
		text-decoration:none;
		text-shadow:0px 0px 0px #365dd1;
		margin-left:298px;
	}
	.BtnReview:hover {
		background:linear-gradient(to bottom, #058fff 5%, #95cff0 100%);
		background-color:#058fff;
	}
	.BtnReview:active {
		position:relative;
		top:1px;
	}
	
	.reviews{
		text-align:center;
		margin:28px;
		
	}
	
	#academyLogo{
		border:3px solid #B9B5B5;
		position:absolute;
		z-index:2;
		bottom:20px;
		left:20px;
	}
	
	#bootLogo{
		position:absolute;
		z-index:1;
	}
	
	#logoBox{
	position:relative;
	width: 100%;
	height: 280px;	
	top:20px;
	}

	#wrap{
		width:100%;
		margin:0,auto;
	}
	
</style>
</head>

<body>
<div id="wrap">
	<header>
		<nav>
			<img id="dotbogi" src=".\images\돋보기.png" width=30px; height=30px;>
			<input type="text" name="keyword" size="15">
			<button class="login">로그인</button>
			
		</nav>
	</header>
	
	<section id="section1">
		<article id="logoBox">
			<img id="bootLogo" src=".\images\플레이데이터학원사진.png" width=830px; height=200px;>
			<img id="academyLogo" src=".\images\플레이데이터로고.png" width=100px; height=100px;>
		</article>
	</section>
	<section id="section2">
		<article>	
			<div class="reviews">강사진 만족도<br><br>
			<select name = "teachScore">
	          <option value = "5" selected>⭐⭐⭐⭐⭐</option>
	          <option value = "4">⭐⭐⭐⭐</option>
	          <option value = "3">⭐⭐⭐</option>
	          <option value = "2">⭐⭐</option>
	          <option value = "1">⭐</option>
	       </select>
			</div>
			<div class="reviews">학습환경 만족도<br><br>
			<select name = "learnScore">
	          <option value = "5" selected>⭐⭐⭐⭐⭐</option>
	          <option value = "4">⭐⭐⭐⭐</option>
	          <option value = "3">⭐⭐⭐</option>
	          <option value = "2">⭐⭐</option>
	          <option value = "1">⭐</option>
	       </select>
	       </div>
			<div class="reviews">교육지원 수준<br><br>
			<select name = "eduScore">
	          <option value = "5" selected>⭐⭐⭐⭐⭐</option>
	          <option value = "4">⭐⭐⭐⭐</option>
	          <option value = "3">⭐⭐⭐</option>
	          <option value = "2">⭐⭐</option>
	          <option value = "1">⭐</option>
	       </select>
	       </div>
			<div class="reviews">총 평점<br><br>
			<select name = "totalScore">
	          <option value = "5" selected>⭐⭐⭐⭐⭐</option>
	          <option value = "4">⭐⭐⭐⭐</option>
	          <option value = "3">⭐⭐⭐</option>
	          <option value = "2">⭐⭐</option>
	          <option value = "1">⭐</option>
	       </select>
	       </div>
	
		</article>
	
	
	
		<article>
		<p>좋았던 점</p>
		<form method="post" action="bootcamp/BootcampSerevlet" >
			<textarea  name= "goodmemo" rows=7 cols=100% ></textarea><br>
		</form>
		</article>
		<article>
		<p>아쉬웠던 점</p>
		<form>
			<textarea  name= "badmemo" rows=7 cols=100% ></textarea><br>
		</form>
		</article>
		<article>
			<div>
				<button class="BtnReview">후기 제출하기</button>
			</div>	
		</article>
	</section>
</div>	
</body>

</html>