<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">

	<form action="">
		<div class="form-group">
			<label for="title">Title</label> <input type="text" name="title" id="title" class="form-control">
		</div>

		<div class="form-group">
			<label for="content">Content</label>
			<textarea name="content" id="content" rows="5" class="form-control content"></textarea>
		</div>
	</form>
	<button type="button" id="btn--save" class="btn btn-primary">저장</button>
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