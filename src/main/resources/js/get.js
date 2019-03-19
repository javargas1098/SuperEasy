GET: $(document).ready(
		function() {

			// GET REQUEST
			$("#loggin").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "XXXXX",
					success : function(result) {
						if (result.status == "success") {
							var url = "xxx.html"; 
							$(location).attr('href',url);
							console.log("Success: ", result);
						} else {
							$('#getResultDiv ul').empty();
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})