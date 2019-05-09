var subastaConItem = (function() {
	return {
		llenar : function() {
			axios.get('/superEasy/auction/'+window.location.href.split('=')[1]).then(function(response) {
				// console.log(response.data);
				var json = response.data;

				var table = document.getElementById("table");

				$("#table").empty();

				var thead = document.createElement("thead");
				var tr = document.createElement("tr");

				for (m in json) {
					var th = document.createElement("th");
					th.innerHTML = m;
					tr.appendChild(th);
				}
				thead.appendChild(tr);
				table.appendChild(thead);

				// Tbody

				var tbody = document.createElement("tbody");
				var tr = document.createElement("tr");

				for (m in json) {
					var td = document.createElement("td");
					td.innerHTML = json[m];
					tr.appendChild(td);
				}
				tbody.appendChild(tr);
				table.appendChild(tbody);

				var par = document.getElementById("actualButton");
				$(document).ready(function() {
					$('#table').DataTable();
				});

			});

		}
	}

})();