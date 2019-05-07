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
			
			if(window.localStorage.getItem('key')!=null){
				document.getElementById('loginul').innerHTML="";
				document.getElementById('registerul').innerHTML="";
				var email=atob(window.localStorage.getItem('key')).split(":")[0];
				apiUser.getUserbyEmail(email,function(u){
					document.getElementById('userName').innerHTML=u;
					document.getElementById('botonLogout').style.display="block";
					
				});
			}
			else{
				document.getElementById('NuevoProducto').innerHTML="";
			}
		},
		getUserCredential:function(){
			console.info(window.localStorage.getItem('key')); //hash
			console.info(atob(window.localStorage.getItem('key'))); //decifrado
		},
		logOut:function(){
			window.localStorage.removeItem('key');
			alert('se ha desconectado correctamente');
			location.replace("index.html");
		}
		
	}
	
})();