postSubasta = (function() {

	return {
		postItem : function() {
			var data = {
				email:atob(window.localStorage.getItem('key')).split(":")[0],
				marca:$("#productmarca").val(),
				modelo:$("#productmodel").val(),
				description:$("#productdescription").val()
				
			};
			$.ajax({
				method : "POST",
				contentType : "application/json",
				url : "superEasy/saveUser",
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(data) {
					
					alert('Se creo, Ya puede ingresar con sus datos');
				},
				error : function() {				
					alert("Hay un error en los datos ingresados por favor intentelo nuevamente");
					// si se puede crear usuario pero tira esta alerta
				}
			});
		}

	
	}

})();