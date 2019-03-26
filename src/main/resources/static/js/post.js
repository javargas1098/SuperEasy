post = (function() {
	function ajaxPost() {
		var formData = {
			name : $("#username").val(),
			email : $("#email").val(),
			password : $("#password").val(),
			number: $("#number").val

		}
		$.ajax({
			
			type : "POST",
			contentType : "application/json",
			url : "/saveUser",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if (result.status == "success") {
					$("#postResultDiv").html(
							"" + result.data.username
									+ "Usuario agregado! <br>");
				} else {
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			}
		});
	}

	return {
		postUser : function() {
			ajaxPost();

		}
	}

})();
