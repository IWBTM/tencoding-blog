<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/auth/loginProc" method="POST">
		<div class="form-group">
			<label for="username">username</label> <input type="text" class="form-control" placeholder="Enter username" id="username" name="username"
				value="teco">
		</div>
		<div class="form-group">
			<label for="password">password</label> <input type="password" class="form-control" placeholder="Enter password" id="password" name="password"
				value="123">
		</div>
		<button type="submit" id="btn--login" class="btn btn-primary">sign in</button>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=b6cb672f15bbfb750480119395e3ae87&redirect_uri=http://localhost:9090/auth/kakao/callback&response_type=code"><img alt="카카오로그인" src="/image/kakao_login.png" width="78" height="38"> </a>
	</form>
</div>
<!-- <script type="text/javascript" src="/js/user.js"></script> -->
<%@ include file="../layout/footer.jsp"%>