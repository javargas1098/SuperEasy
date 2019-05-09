var subasta=( function(){
	class Bid{
		constructor(value){
			this.value=value;
		}
	}
	var stompClient=null;
	var idsubasta=null;
	var user=null;
	var ConnectAndSubscribe = function (idsubasta,user) {  
		//TODO pasar por el servidor (/app)
		var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        stompClient.connect({},function(frame){
        	stompClient.subscribe('/topic/'+idsubasta+"/"+user, function (eventbody) {
                var newValue=JSON.parse(eventbody.body);
                console.log(newValue);
                subasta.updateValue(newValue);
            });
        });
    };
    return {
    	init:function(idsubasta,user){
    		ConnectAndSubscribe(idsubasta,user);
    		subasta.idsubasta=idsubasta;
    		subasta.user=user;
    	},
    	ofertar:function(value){
    		
    		if(window.localStorage.getItem('key')!=null){
    			var x = parseInt(document.getElementById("actualValue").textContent);
        		if(value>x){
        			stompClient.send("/app/"+subasta.idsubasta+"/"+subasta.user,{},JSON.stringify(value));
        			
        		}
        		else{
        			alert("no se puede ofertar un valor menor");
        		}
    		}
    		else{
    			alert("debe estar logeado para ofertar");
    		}
    		
    		
    	},
    	updateValue:function(newValue){
    		var element= document.getElementById("actualValue");
    		element.innerHTML = newValue;
    	}
    }
	
})();