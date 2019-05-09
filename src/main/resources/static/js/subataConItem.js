function setTable() {

	var table = $('#example').DataTable({
		"columns" : [ {
			"data" : "seller"
		}, {
			"data" : "modelo"
		}, {
			"data" : "marca"
		} ]
	});
	table = $('#example').DataTable({
		"ajax" : {
			"url" : "/superEasy/auctions",
			"dataSrc" : ""
		},
		"columns" : [ {
			"data" : "seller"
		}, {
			"data" : "modelo"
		}, {
			"data" : "marca"
		}

		]
	});
}