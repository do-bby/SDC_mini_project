<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="MemberLoginRegister.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>로그인|회원가입</title>
</head>
<script>
$(function() {
	  tab = $('.tabs h3 a');
	  tab.on('click', function(event) {
	    event.preventDefault();
	    tab.removeClass('active');
	    $(this).addClass('active');
	    tab_content = $(this).attr('href');
	    $('div[id$="tab-content"]').removeClass('active');
	    $(tab_content).addClass('active');
	  });
	});

//SLIDESHOW
$(function() {
$('#slideshow > div:gt(0)').hide();
setInterval(function() {
  $('#slideshow > div:first')
  .fadeOut(1000)
  .next()
  .fadeIn(1000)
  .end()
  .appendTo('#slideshow');
}, 3850);
});

//CUSTOM JQUERY FUNCTION FOR SWAPPING CLASSES
(function($) {
'use strict';
$.fn.swapClass = function(remove, add) {
  this.removeClass(remove).addClass(add);
  return this;
};
}(jQuery));

//SHOW/HIDE PANEL ROUTINE (needs better methods)
$(function() {
$('.agree, .forgot, #toggle-terms, .log-in, .sign-up').on('click', function(event) {
  event.preventDefault();
  var user = $('.user'),terms = $('.terms'),form = $('.form-wrap'),recovery = $('.recovery'),close = $('#toggle-terms'),arrow = $('.tabs-content .fa');
  if ($(this).hasClass('agree') || $(this).hasClass('log-in') || ($(this).is('#toggle-terms')) && terms.hasClass('open')) {
    if (terms.hasClass('open')) {
      form.swapClass('open', 'closed');
      terms.swapClass('open', 'closed');
      close.swapClass('open', 'closed');
    } else {
      if ($(this).hasClass('log-in')) {
        return;
      }
      form.swapClass('closed', 'open');
      terms.swapClass('closed', 'open').scrollTop(0);
      close.swapClass('closed', 'open');
      user.addClass('overflow-hidden');
    }
  }
  else if ($(this).hasClass('forgot') || $(this).hasClass('sign-up') || $(this).is('#toggle-terms')) {
    if (recovery.hasClass('open')) {
      form.swapClass('open', 'closed');
      recovery.swapClass('open', 'closed');
      close.swapClass('open', 'closed');
    } else {
      if ($(this).hasClass('sign-up')) {
        return;
      }
      form.swapClass('closed', 'open');
      recovery.swapClass('closed', 'open');
      close.swapClass('closed', 'open');
      user.addClass('overflow-hidden');
    }
  }
});
});

//DISPLAY MSSG
$(function() {
$('.recovery .button').on('click', function(event) {
  event.preventDefault();
  $('.recovery .mssg').addClass('animate');
  setTimeout(function() {
    $('.form-wrap').swapClass('open', 'closed');
    $('.recovery').swapClass('open', 'closed');
    $('#toggle-terms').swapClass('open', 'closed');
    $('.tabs-content .fa').swapClass('active', 'inactive');
    $('.recovery .mssg').removeClass('animate');
  }, 2500);
});
});


</script>
</head>
<body>
	<!-- LOGIN MODULE -->
	<div class="login">
		<div class="wrap">

			<!-- LOGIN FORM -->
			<div class="user">

				<!-- LOGO -->
				<div class="logo">
					<!-- logo 대체 필요 -->
					<a href="#"><img
						src="http://res.cloudinary.com/dpcloudinary/image/upload/v1506186248/logo.png"
						alt=""></a>
				</div>
				<!-- TOGGLE -->
				<div id="toggle-wrap">
					<div id="toggle-terms">
						<div id="cross">
							<span></span> <span></span>
						</div>
					</div>
				</div>

				<!-- RECOVERY -->
				<div class="recovery">
					<h2>비밀번호 찾기</h2>
					<p>비밀번호를 찾고자 하는 아이디를 입력하세요</p>
					<form class="recovery-form" action="find_pwd" method="post">
						<input type="text" class="input" id="user_recover" placeholder="이메일을 입력하세요">
						<input type="submit" class="button" value="Submit">
					</form>
					<p class="mssg">비밀번호 재설정을 위한 이메일이 발송되었습니다</p>
				</div>

				<!-- FORM -->
				<div class="form-wrap">
					<!-- TABS -->
					<div class="tabs">
						<h3 class="login-tab">
							<a class="log-in active" href="#login-tab-content"><span>로그인</span></a>
						</h3>
						<h3 class="signup-tab">
							<a class="sign-up" href="#signup-tab-content"><span>회원가입</span></a>
						</h3>
					</div>
					<!-- TABS CONTENT -->
					<div class="tabs-content">
						<!-- TABS CONTENT LOGIN -->
						<div id="login-tab-content" class="active">
							<form class="login-form" action="login" method="post">
								<input type="hidden" name="action" value="login">
								<input type="text" class="input" id="user_login" name="id" autocomplete="off" placeholder="아이디를 입력하세요" required><br>
								<input type="password" class="input" id="user_pass" name="pwd" autocomplete="off" placeholder="비밀번호를 입력하세요" required><br>
								<aside>
									<h4>${ msg }</h4>
								</aside> 
								<input type="submit" class="button" value="로그인"><br>
							</form>
							<div class="help-action">
								<p>
									<i class="fa fa-arrow-left" aria-hidden="true"></i><a
										class="forgot" href="#">비밀번호 찾기</a>
								</p>
							</div>
						</div>
						<!-- TABS CONTENT SIGNUP -->
						<div id="signup-tab-content">
							<form class="signup-form" action="/member" method="post">
								<input type="text" class="input" name=id autocomplete="off" placeholder="아이디를 입력하세요" required><br> 
								<input type="password" class="input" name=pwd autocomplete="off" placeholder="패스워드를 입력하세요" required><br> 
								<input type="text" class="input" name=name autocomplete="off" placeholder="이름을 입력하세요" required><br> 
								<input type="text" class="input" name=email autocomplete="off" placeholder="이메일을 입력하세요" required><br> 
								<input type="text" class="input" name=phone autocomplete="off" placeholder="전화번호를 입력하세요" required><br> 
								<input type="text" class="input" name=nick autocomplete="off" placeholder="닉네임을 입력하세요" required><br> 
								<input type="submit" class="button" value="회원가입 완료하기">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</body>
</html>