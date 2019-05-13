postSubasta = (function() {
	var today = new Date();
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0'); // January is 0!
	var yyyy = today.getFullYear();
	var hour = String(today.getHours()).padStart(2, '0');
	var minutes = String(today.getMinutes());
	var UUID,UUIDS;
	
	var UUIDJSON2 = $.ajax({
		url : "https://helloacm.com/api/guid-generator/",

		success : function(data) {
			UUIDS = data.guid[0];
			console.log(data.guid[0]);
		}
	});
	var UUIDJSON = $.ajax({
		url : "https://helloacm.com/api/guid-generator/",

		success : function(data) {
			UUID = data.guid[0];
		}
	});
	
	// today = (yyyy + '/' + mm + '/' + dd + " " + hour + ':' + minutes);
	var today = new Date();
	var horaFinal;
	
	
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
				horaFinal : new Date($('#productfecha').val()),
				horaIni : today,
				item : data,
				idSubasta : UUIDS,
				image:$("#productimage").val()

			};
			console.log(datasubasta);
			console.log(UUIDS);
			console.log(atob(window.localStorage.getItem('key')).split(":")[0]);
			var offset = new Date($('#productfecha').val())-today;
			console.log(offset)
			
			
			if (window.localStorage.getItem('key') != null && offset > 0  ) {
				
				
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
						alert("Item creado exitodamente");
						//location.reload();
						// si se puede crear usuario pero tira esta alerta
					}

				});
				$.ajax({
					method : "POST",
					contentType : "application/json",
					url : "superEasy/saveAuction/"+UUIDS,
					data : JSON.stringify(datasubasta),
					dataType : 'json',
					success : function(data) {

						alert('Se creo, ');
					},
					error : function() {				
						alert("Subasta creada exitosamente");
						location.replace("subastaspreview.html?id="+UUIDS);
						//location.reload();
						// si se puede crear usuario pero tira esta alerta
					}

				});
				
				
			}else{
    			alert("Debe estar logeado o ingreso una fecha inadecuada ");
    		};
    		
		},
		possibleNew:function(){
			
			
			
		}

	}

})();