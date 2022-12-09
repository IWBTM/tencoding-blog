
// # : id, . : class

// 이렇게 하면 객체를 찾아줌
// 이벤트 바인딩
$('#join--submit').on('click', function() {

	// 오브젝트 만드는 문법
	let data = {

		// username의 택스트 값이 담긴다. (변수 선언)
		username: $('#username').val(),
		password: $('#password').val(),
		email: $('#email').val()
	};

	console.log("data : " + data.username);
	console.log("data : " + data.password);
	console.log("data : " + data.email);

	$.ajax({
		type: 'POST',
		url: '/blog/dummy/signup',
		data: JSON.stringify(data),	// Object를 JSon 형식으로 변환해준다.
		contentType: 'application/json; charset=UTF-8',
		dataType: 'json'	// 응답 받을 때 어떤 타입으로 받을지 지정한다.
	}).done(
		// done : 성공 했을 때 여기로 온다.
		function(response) {
			console.log(response);
		}).fail(
			function(error) {
				console.log(error);
			});

});

