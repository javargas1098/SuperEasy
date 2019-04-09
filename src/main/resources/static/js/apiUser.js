apiUser = (function() {
	return {
		CreateUser : function(user, mail, phone, password, address) {
			$.post("/superEasy/users", {
				"id" : "1",
				"name" : '"' + user + '"',
				"addres" : '"' + address + '"',
				"number" : '"' + phone + '"',
				"jairitos" : "0",
				"jairitosBenefit" : "0",
				"jairitosCongelados" : "0",
				"password" : '"' + password + '"',
				"email" : '"' + mail + '"'
			});
		},
		evaluateCredentials : function(name, password, callback) {
			console.log(name + " " + password);
			$.get("superEasy/credentials/" + name + "/" + password, function(
					data) {
				callback(data);
			});
		}

	}
})();