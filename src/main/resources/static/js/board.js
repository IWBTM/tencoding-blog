
let index = {
	init: function() {
		$("#btn--save").bind("click", () => {
			this.save();
		});
		$("#btn--delete").bind("click", () => {
			this.deleteById();
		});
		$("#btn--update").bind("click", () => {
			this.update();
		});
	},
	save: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		}

		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; chraset=UTF-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.status == "OK") {
				alert("정상적으로 업로드 되었습니다.");
				location.href = "/";
			} else {
				alert("업로드에 실패 하였습니다.");
			}
			console.log(data);
		}).fail(function(error) {
			alert("오류 발생 !!.");
			alert(error.responseJSON.error);
		});
	},
	deleteById: function() {
		let id = $("#board-id").text();
		$.ajax({
			type: "DELETE",
			url: "/api/board/" + id
		}).done(function(data, textStatus, xhr) {
			if (data.status == "OK") {
				alert("삭제가 완료 되었습니다.");
				location.href = "/";
			} else {
				alert("다시  시도해주세요.");
			}
		}).fail(function() {
			alert("다시  시도해주세요.");
		});
	},
	update: function() {
		// HTML 태그에 직적 속성을 정의할 수 있다. data-~~~
		// 직접 정의한 속성의 값을 가져오기 (선택자).attr(속성id값)
		let boardId = $("#board-id").attr("data-id");
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		}

		$.ajax({
			type: "PUT",
			url: "/api/board/" + boardId,
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.status) {
				alert("수정에 성공하였습니다. ");
				location.href = "/";
			} else {
				alert("수정에 실패하였습니다. ");
			}
		}).fail(function(error) {
			alert("수정 중 예기치 못 한 오류가 발생하였습니다. ");
		});

	}
};
index.init();