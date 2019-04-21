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
					
					alert('Usuario creado exitosamente, Ya puede ingresar con sus datos');
				},
				error : function() {				
					alert("Hay un error en los datos ingresados por favor intentelo nuevamente");
					// si se puede crear usuario pero tira esta alerta
				}
			});
		}
	}

})();
