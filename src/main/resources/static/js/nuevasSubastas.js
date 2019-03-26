nuevasSubastas = (function() {
	// Codigo realizado en conjunto con Javier Vargas
	var actualizarTabla = function(cine) {
		$("#NuevasSubastas").find('ul').empty();
		var table = $("#NuevasSubastas");
		for (var i = 0; i < cine.functions.length; i++) {
			table.append("<tr><td>" + cine.name + "</td><td>"
					+ cine.functions[i].movie.name + "</td><td>"
					+ cine.functions[i].date + "</td><td>"
					+ cine.functions[i].seats.length + "</td></tr>")
		}
	}

	return {
		getCinemaByName : function(name) {
			return apiclient.getCinemaByName(name, function(cine) {
				actualizarTabla(cine);
			});
		}
	}
	

})();

