
let index = {
	init: function() {
		$("#btn--save").bind("click", () => {
			this.save();
		});
		$("#btn--delete").bind("click", () => {
			this.deleteById();
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
		}).done(function(data, status, xhl) {
			if (data.status == "OK") {
				alert("삭제가 완료 되었습니다.");
				location.href = "/";
			} else {
				alert("다시  시도해주세요.");
			}
		}).fail(function() {
			alert("다시  시도해주세요.");
		});
	}
};
index.init();