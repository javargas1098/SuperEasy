appuser = (function() {
	return {
		evaluateCredentials : function(name, password) {
			return apiUser.evaluateCredentials(name, password, function(
					response) {

				if (response) {
					location.replace("index.html");

					window.localStorage.setItem('key', btoa(name + ":"
							+ password));

				} else {
					document.getElementById("ActivateModal").click();
				}
			});
		},
		getUser : function() {
			console.info(window.localStorage.getItem('key')); // hash
			console.info(atob(window.localStorage.getItem('key'))); // decifrado

			if (window.localStorage.getItem('key') != null) {
				document.getElementById('loginul').innerHTML = "";
				document.getElementById('registerul').innerHTML = "";
				var email = atob(window.localStorage.getItem('key')).split(":")[0];
				apiUser
						.getUserbyEmail(
								email,
								function(u) {
									document.getElementById('userName').innerHTML = u;
									document.getElementById('botonLogout').style.display = "block";

								});
			} else {
				document.getElementById('NuevoProducto').innerHTML = "";
			}
		},
		getUserCredential : function() {
			console.info(window.localStorage.getItem('key')); // hash
			console.info(atob(window.localStorage.getItem('key'))); // decifrado
		},
		logOut : function() {
			window.localStorage.removeItem('key');
			alert('se ha desconectado correctamente');
			location.replace("index.html");
		},
		getSubastas : function() {
			return apiUser
					.getAllSubastas(function(response) {
						
						var today = new Date();
						for ( var it in response) {
							console.log(response[it]);
							var bid = document.createElement("LI");
							var finish = new Date(response[it].horaFinal);
							var left = Math.round((finish.getTime() - today
									.getTime()) / 3600000);

							console.log(left);

							if (left >= 0) {
								var onclictext = '"location.href='
										+ "'subastaspreview.html?id="
										+ response[it].idSubasta + "'" + '"';
								bid.className += "d-flex flex-row align-items-center justify-content-start";
								var htmltext = "<li class='d-flex flex-row align-items-center justify-content-start'>"
										+ "<div class='schedule_image'>"
										+ "<img src='"+response[it].image+"' alt=''>"
										+ "</div>"
										+ "<div class='schedule_content'>"
										+ "<div class='schedule_time'>"
										+ left
										+ " Horas</div>"
										+ "<div class='schedule_title'>"
										+ response[it].item.marca
										+ " "
										+ response[it].item.modelo
										+ "</div>"
										+ "<div class='schedule_info'>"
										+ "Vendedor: <a>"
										+ response[it].seller
										+ "</a>"
										+ "</div>"
										+ "</div>"
										+

										"<button style=''position: absolute; right: 0;' class='btn btn-success loginFormElement' onclick="
										+ onclictext
										+ "> Visitar</button></li>";

								var actual = document
										.getElementById("listaSubastas").innerHTML;
								actual += htmltext;
								document.getElementById("listaSubastas").innerHTML = actual;
							}

						}

					});
		}

	}

})();