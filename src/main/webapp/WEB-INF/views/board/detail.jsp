<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<button class="btn bg-secondary" onclick="history.back();">뒤로 가기</button>
	<button class="btn btn-warning">수정</button>
	<button class="btn btn-danger" id="btn--delete">삭제</button>
	<br> <br> <br>
	<div>
		글 번호 : <span id="board-id"> <i>${board.id}</i></span>
	</div>
	<div>
		글 작성자 : <span id=""> <i>${board.user.username}</i></span>
	</div>
	<br> <br> <br>
	<div class="">

		<h3>${board.title}</h3>
	</div>

	<div>${board.content}</div>
	<br> <br>
</div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>