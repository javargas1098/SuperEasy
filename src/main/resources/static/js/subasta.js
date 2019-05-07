var subasta=( function(){
	class Bid{
		constructor(value){
			this.value=value;
		}
	}
	var stompClient=null;
	var product=null;
	var ConnectAndSubscribe = function (product) {  
		//TODO pasar por el servidor (/app)
		var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        stompClient.connect({},function(frame){
        	stompClient.subscribe('/topic/1/1', function (eventbody) {
                var newValue=JSON.parse(eventbody.body);
                console.log(newValue);
                subasta.updateValue(newValue);
            });
        });
    };
    return {
    	init:function(product){
    		ConnectAndSubscribe(product);
    		subasta.product=product;
    	},
    	ofertar:function(value){
    		if(window.localStorage.getItem('key')!=null){
    			var x = parseInt(document.getElementById("actualValue").textContent);
        		if(value>x){
        			stompClient.send("/app/1/1",{},JSON.stringify(value));
        			
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