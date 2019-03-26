appuser=(function(){
	return{
		evaluateCredentials:function(name,password){
			return apiUser.evaluateCredentials(name,password,function(response){
				if(response){
					location.replace("logged.html");
				}
				else{
					document.getElementById("ActivateModal").click();
				}
			});
		}
	}
	
})();