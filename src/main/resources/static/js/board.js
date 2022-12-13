
let index = {
	init: function() {
		$("#btn--save").bind("click", () => {
			this.save();
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
	}
};
index.init();