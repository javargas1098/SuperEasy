appuser=(function(){
	return{
		evaluateCredentials:function(name,password){
			return apiUser.evaluateCredentials(name,password,function(response){
				
				if(response){
					location.replace("index.html");
					
					window.localStorage.setItem('key', btoa(name+":"+password));
					
				}
				else{
					document.getElementById("ActivateModal").click();
				}
			});
		},
		getUser:function(){
			console.info(window.localStorage.getItem('key')); //hash
			console.info(atob(window.localStorage.getItem('key'))); //decifrado
			
		}
	}
	
})();