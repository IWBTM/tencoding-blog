<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<c:forEach var="boar" items="${boards.content}">
	<div class="card m-2">
		<div class="card-body">
			<h4>${boar.title}</h4>
			<p>${boar.content}</p>
			<a href="/board/${boar.id}" class="btn btn-primary">show detail</a>
		</div>
	</div>
	<br>
</c:forEach>

<!-- 첫번째 페이지면 true
page.first == ture / false
마지막 페이지면 true
page.last == ture / false -->

<ul class="pagination justify-content-center">
	<c:set var="isDisabled" value="disabled"></c:set>
	<c:set var="isNotDisabled" value=""></c:set>
	<li class="page-item ${boards.first ? isDisabled : isNotDisabled }"><a class="page-link" href="?page=${boards.number - 1}">뒤로 가기</a></li>
	<li class="page-item ${boards.last ? isDisabled : isNotDisabled  }"><a class="page-link" href="?page=${boards.number + 1}">앞으로 가기</a></li>
</ul>
<%@ include file="layout/footer.jsp"%>
