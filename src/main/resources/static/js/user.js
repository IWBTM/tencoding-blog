
// 선언
let index = {
	init: function() {

		// 최근엔 on보다 bind를 많이 쓴다.
		$("#btn--save").bind("click", () => {
			this.save();
		});

		$("#btn--login").bind("click", () => {
			this.login();
		});
	},
	save: function() {
		// form 태그에 사용자가 입력한 값 들을 자바 스크립트 변수로 가지고 옴
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		console.log(data);

		// TODO!! : ajax로 통신 (data -> json형식 -> 자바로 전송)

		// ajax 통신 구현
		$.ajax({
			// 회원가입 요청
			// type : 통신의 요청 메서드 방식
			type: "POST",
			url: "/auth/joinProc",
			// http 메시지 바디에 JSON형식으로 변환한 오브젝트가 들어간다. 즉, JSON 문자열이 들어간다.
			data: JSON.stringify(data),

			// 보낼 때의 데이터 타입
			contentType: "application/json; chraset=UTF-8",

			// 응답이 왔을 때 MIME TYPE 지정
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.status == "OK") {
				alert("회원가입 완료");
				location.href = "/";
			} else {
				alert("회원가입 실패");
			}
		}).fail(function(error) {
			alert("회원가입 실패.. ㅠㅠ " + error.responseJSON.message);
		});
	},

	login: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
		};

		$.ajax({
			type: "POST",
			url: "/api/user/login",
			data: JSON.stringify(data),
			contentType: "application/json; chraset=UTF-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			alert("로그인에 성공 하셨습니다.");
			console.log(data);
			console.log(textStatus);
			console.log(xhr);
			location.href = "/";
		}).fail(function(error) {
			alert("로그인에 실패 하셨습니다.");
		});
	}
}

// 호출
index.init();































