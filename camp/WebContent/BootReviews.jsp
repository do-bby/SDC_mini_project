<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.ReviewVO,bootcamp.BootcampVO,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BootCamp Review App</title>
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
		padding:10px 30px;
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
		border-radius:10px;
	}
	
	#bootLogo{
		position:absolute;
		z-index:1;
		border-radius:10px;
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
	
	#BtnInsertReview{
		position:relative;
		left:400px;
	
	}
	
	.mapAndScore{
		display:inline-block;
	}
	
</style>

<script type="text/javascript">
var dom;

<% %>
function inputaddress(addr) {
	var url= 'https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyDy81EbO46BRSnX1DOgg_F84bhsdbku2z4&address='
						+ encodeURIComponent(addr)
				
   	var request = new XMLHttpRequest();
	request.onload = function(event) {
		if (request.status == 200) {
			var obj = JSON.parse(request.responseText);
			lat = obj.results[0].geometry.location.lat;
			lng = obj.results[0].geometry.location.lng;
			dom.innerHTML = '';
			googlemap(lat, lng);
		}
	};
	request.open('GET', url, true);
	request.send();
}

window.onload = function (){
	dom = document.getElementById('map');
	document.getElementById('btn').onclick = inputaddress;
}

const dom = document.getElementById("map");
if(dom) {
	new google.maps.Map(dom, {
    	center: { lat: 37.48650, lng: 127.020600 },
    	zoom: 16
  	});
}     
</script>
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
			<a href="https://playdata.io/"><img id="academyLogo" src=".\images\플레이데이터로고.png" width=100px; height=100px;></a>
				
			
		</article>
		
		<article>
			<div id="BtnInsertReview">
				<button class="BtnReview" onclick="location.href='BootReviewApp.jsp' ">리뷰 등록하기</button>
			</div>
		</article>
	</section>
	<section id="section2">
		<article class="mapAndScore">
		<div id="map" style="width:300px; height:200px;"></div>
		</article>
		<article class="mapAndScore">
		평점들 
		</article>
	</section>
</div>	
</body>

</html>