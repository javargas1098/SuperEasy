$(document).ready(
		function() {

			// SUBMIT FORM
			$("#signup-form").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					username : $("#username").val(),
					email : $("#email").val(),
					password : $("#password").val()

				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "safeUser",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(
									"" + result.data.bookName
											+ "Usuario agregado! <br>");
						} else {
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});

			}

		})