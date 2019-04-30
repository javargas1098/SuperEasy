postSubasta = (function() {
	var today = new Date();
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0'); // January is 0!
	var yyyy = today.getFullYear();
	var hour = String(today.getHours()).padStart(2, '0');
	var minutes = String(today.getMinutes());

	today = mm + '/' + dd + '/' + yyyy + "  " + hour + ':' + minutes;

	return {

		postItem : function() {
			var data = {
				marca : $("#productmarca").val(),
				modelo : $("#productmodel").val(),
				descripcion : $("#productdescription").val()

			};
			var datasubasta = {
				seller : atob(window.localStorage.getItem('key')).split(":")[0],
				precioSugerido : $("#productprice").val().toString(),
				horaFin : $("#productfecha").val(),
				horaini : today

			};
			console.info(datasubasta);
			$
					.ajax({
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
			$
					.ajax({
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