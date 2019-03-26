post = (function() {

	return {
		postUser : function() {
			var data = {
				name : $("#username").val(),
				email : $("#email").val(),
				password : $("#password").val(),
				number : $("#telefono").val().toString()
			};
			console.info(data);
			$.ajax({
				method : "POST",
				contentType : "application/json",
				url : "superEasy/saveUser",
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(data) {
					alert('data: ' + data);
				},
				error : function() {
					alert("There was an error. Try again please!");
				}
			});
		}
	}

})();
