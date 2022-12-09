<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<!-- <script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
 -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>form 테스트</h1>

	<div class="container">
		<form action="/blog/dummy/signup2" method="post">
			<div class="form-group">
				<label for="username">사용자 이름:</label> 
				
				<input type="text"
					class="form-control" placeholder="Enter username" id="username"
					name="username" value="경민쿤">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> 
				
				<input type="password"
					class="form-control" placeholder="Enter password" id="password"
					name="password" value="00">
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				
				 <input type="email"
					class="form-control" placeholder="Enter email" id="email"
					name="email" value="a@naver.com">
			</div>
		<!--	 <button type="submit" class="btn btn-primary">회원가입</button>  -->
		</form>
		<button id="join--submit" class="btn btn-primary">회원가입</button>
	</div>

	<!-- src는 src폴더 -->
	<script src="/blog/js/join.js"></script>
</body>
</html>