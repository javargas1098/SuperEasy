postSubasta = (function() {
	var today = new Date();
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0'); // January is 0!
	var yyyy = today.getFullYear();
	var hour = String(today.getHours()).padStart(2, '0');
	var minutes = String(today.getMinutes());
	var UUID;
	var UUIDJSON = $.ajax({
		url : "https://helloacm.com/api/guid-generator/",

		success : function(data) {
			UUID = data.guid[0];
		}
	});

	// today = (yyyy + '/' + mm + '/' + dd + " " + hour + ':' + minutes);
	// var horaFinal = new Date();

	return {

		postItem : function() {
			var data = {
				marca : $("#productmarca").val(),
				modelo : $("#productmodel").val(),
				descripcion : $("#productdescription").val(),
				id : UUID

			}
			var datasubasta = {
				seller : atob(window.localStorage.getItem('key')).split(":")[0],
				precioSugerido : $("#productprice").val().toString(),
				horaFinal : moment($('#productfecha').val()).format(
						'MM/DD/YYYY HH:mm'),

				horaIni : today,
				item : data

			};
			if (window.localStorage.getItem('key') != null) {
				console.info(datasubasta);
				// console.info(horaFin);
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
						alert("item creado exitodamente");
						location.reload();
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
						alert("subasta creada exitosamente");
						location.reload();
						// si se puede crear usuario pero tira esta alerta
					}

				});
			}else{
    			alert("debe estar logeado ");
    		};
    		
		},

	}

})();