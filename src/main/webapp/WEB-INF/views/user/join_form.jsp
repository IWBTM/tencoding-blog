<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="username">username:</label> <input type="text" class="form-control" placeholder="Enter username" id="username" value="min">
		</div>
		<div class="form-group">
			<label for="password">password:</label> <input type="password" class="form-control" placeholder="Enter password" id="password" value="123">
		</div>
		<div class="form-group">
			<label for="email">Email:</label> <input type="email" class="form-control" placeholder="Enter email" id="email" value="a@naver.com">
		</div>
	</form>
	<button type="button" id="btn--save" class="btn btn-primary">sign up</button>
</div>

<!-- HTML 렌더링이 모두 끝난 후 js코드 -->
<script type="text/javascript" src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>