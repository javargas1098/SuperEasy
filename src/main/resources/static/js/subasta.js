var subasta=( function(){
	class Ofertas{
		constructor(ofertaID,precio,auction,user){
			this.ofertaID=ofertaID;
			this.precio=precio;
			this.auction=auction;
			this.user=user;
			
		}
	}
	var stompClient=null;
	var idsubasta=window.location.href.split("=")[1];
	var user=atob(window.localStorage.getItem('key')).split(":")[0];
	var ConnectAndSubscribe = function (idsubasta,user) {  
		//TODO pasar por el servidor (/app)
		var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        stompClient.connect({},function(frame){
        	stompClient.subscribe('/topic/'+idsubasta, function (eventbody) {
                var newValue=JSON.parse(eventbody.body);
                console.log(newValue);
                subasta.updateValue(newValue.precio);
                var element= document.getElementById("actualWinner");
        		element.innerHTML = newValue.user;
            });
        });
    };
    return {
    	init:function(){
    		
    		ConnectAndSubscribe(idsubasta,user);
    		
    	},
    	ofertar:function(value){
    		
    		if(window.localStorage.getItem('key')!=null){
    			var x = parseInt(document.getElementById("actualValue").textContent);
        		if(value>x){
        			var newBid=new Ofertas(1,value,idsubasta,user);
        			stompClient.send("/app/"+idsubasta,{},JSON.stringify(newBid));
        			
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