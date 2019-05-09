var subastaConItem = (function() {
	return {
		llenar : function() {
			
			axios.get(
					'/superEasy/auction/' + window.location.href.split('=')[1])
					.then(function(response) {
						// console.log(response.data);
						var json = response.data;

						var table = document.getElementById("example");

						$("#example").empty();

						var thead = document.createElement("thead");
						var tr = document.createElement("tr");

						for (m in json) {
							if (m == "seller") {
								var th = document.createElement("th");
								th.innerHTML = m;
								tr.appendChild(th);
							}
							if (m == "item") {
								for (n in json[m]) {
									if (n != "id" && n != "descripcion") {
										var th = document.createElement("th");
										th.innerHTML = n;
										tr.appendChild(th);
									}
								}
							}
						}
						thead.appendChild(tr);
						table.appendChild(thead);

						// Tbody

						var tbody = document.createElement("tbody");
						var tr = document.createElement("tr");

						for (m in json) {
							if (m == "seller") {
								var td = document.createElement("td");
								td.innerHTML = json[m];
								tr.appendChild(td);
							}
							if (m == "item") {
								for (n in json[m]) {
									if (n != "id" && n != "descripcion") {
										var td = document.createElement("td");
										td.innerHTML = json[m][n];
										tr.appendChild(td);
									}
								}
							}
						}
						
						
						tbody.appendChild(tr);
						table.appendChild(tbody);
						
						// Valor Actual ---------------------------------------------------
						var h3 = document.getElementById("actualValue");

						$("#actualValue").empty();
						h3.innerHTML = json["precioActual"];
						
						// Valor Actual ---------------------------------------------------
						
						// Fecha Inicio ---------------------------------------------------
						var h5 = document.getElementById("fechaInicio");

						$("#fechaInicio").empty();
						
						h5.innerHTML =new Date(json["horaIni"]);
						
						// Fecha Inicio ---------------------------------------------------
						
						// Fecha Final ---------------------------------------------------
						var h = document.getElementById("fechaFin");

						$("#fechaFin").empty();
						h.innerHTML = new Date(json["horaFinal"]);
						
						// Fecha Final ---------------------------------------------------
						
						// Descripcion ---------------------------------------------------
						var ul = document.getElementById("descripcion");

						$("#descripcion").empty();

						var li = document.createElement("li");
						li.innerHTML = json["item"]["descripcion"];
						ul.appendChild(li);
						
						// Descripcion ---------------------------------------------------
						// Imagen---------------------------------------------------------
						$("#imageSubasta").empty();
						document.getElementById("imageSubasta").innerHTML ='<img class="d-block w-100" src="'+json["image"]+'"alt="First slide">';
							
						// Imagen---------------------------------------------------------
						
						// hide button ---------------------------------------------------
						var today=new Date();
						var end=new Date(document.getElementById("fechaFin").textContent);
						
						
						if(today>end){
							
							document.getElementById("ofertarButton").style.display="none";
							document.getElementById("Bid").style.display="none";
						}
						// hide button ---------------------------------------------------
						var par = document.getElementById("actualButton");
						$(document).ready(function() {
							$('#example').DataTable();
						});

					});
			
			

		}
	}

})();