postSubasta = (function() {

	return {
		postItem : function() {
			var data = {
				marca:$("#productmarca").val(),
				modelo:$("#productmodel").val(),
				descripcion:$("#productdescription").val()

			};
			var datasubasta={
				seller:atob(window.localStorage.getItem('key')).split(":")[0],
				precioSugerido: $("#productprice").val().toString(),
				horaFin : $("#productfecha").val()
					
			};
			$.ajax({
				method : "POST",
				contentType : "application/json",
				url : "superEasy/saveItem",
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(data) {
					
					alert('Se creo, ');
				},
				error : function() {				
					alert("Hay un error en los datos ingresados por favor intentelo nuevamente");
					// si se puede crear usuario pero tira esta alerta
				}
			});
			$.ajax({
				method : "POST",
				contentType : "application/json",
				url : "superEasy/saveAuction",
				data : JSON.stringify(datasubasta),
				dataType : 'json',
				success : function(data) {
					
					alert('Se creo, ');
				},
				error : function() {				
					alert("Hay un error en los datos ingresados por favor intentelo nuevamente");
					// si se puede crear usuario pero tira esta alerta
				}
			});
		}

	
	}

})();