post = (function() {

	return {
		postUser : function() {
			var data = {
				name : $("#username").val(),
				email : $("#email").val(),
				number : $("#phone").val().toString(),
				password : $("#password").val()
				
			};
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
//					$('body').showMessage({thisMessage: ['Hey! Something bit me!']});
					alert("There was an error. Try again please!");
				}
			});
		}
	}

})();
