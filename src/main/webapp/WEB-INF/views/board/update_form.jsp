<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">

	<form action="">
		<input type="hidden" id="id" value="${principal.user.id}">
		<div class="form-group">
			<label for="title" id="board-id" data-id="${board.id}">글 번호</label>
		</div>
		<div class="form-group">
			<label for="title">username</label> <input type="text" name="username" id="username" class="form-control" value="${principal.user.username}"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="title">제목</label> <input type="text" name="title" id="title" class="form-control" value="${board.title}">
		</div>

		<div class="form-group">
			<label for="content">글 내용</label>
			<textarea name="content" id="content" rows="5" class="form-control content">${board.content}</textarea>
		</div>
	</form>
	<button type="button" id="btn--update" class="btn btn-primary">수정</button>
</div>

<script>
	$('.content').summernote({
		placeholder : '내용을 입력해주세요.',
		tabsize : 2,
		height : 300
	});
</script>
<script type="text/javascript" src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>