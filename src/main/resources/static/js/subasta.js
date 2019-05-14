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
		// TODO pasar por el servidor (/app)
		var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        stompClient.connect({},function(frame){
        	stompClient.subscribe('/topic/'+idsubasta, function (eventbody) {
                var newValue=JSON.parse(eventbody.body);
                console.log(newValue);
                subasta.updateValue(newValue.precio);
                var element= document.getElementById("actualWinner");
        		element.innerHTML = newValue.user;
        		console.log($("#actualWinner").text());
        		Swal.fire({
        			  title: $("#actualWinner").text()+' ¡Superó la última oferta!',
        			  animation: false,
        			  customClass: {
        			    popup: 'animated tada'
        			  }
        			})
            });
        });
    };
    return {
    	init:function(){
    		
    		ConnectAndSubscribe(idsubasta,user);
    		
    	},
    	ofertar:function(value){
    		var email=atob(window.localStorage.getItem('key')).split(":")[0];
    		axios.get(
					'/superEasy/user/'+email+".com")
					.then(function(response) {
						console.log(response.data);
						var json = response.data;
						var today=new Date();
						var end=new Date(document.getElementById("fechaFin").textContent);
						if(window.localStorage.getItem('key')!=null){
			    			var x = parseInt(document.getElementById("actualValue").textContent.split(" ")[1]);
			    			console.log(" actual: "+x+" oferta:"+value+"   dispone de:"+json["jairitos"]);
			    			console.log(parseInt(value)>x);
			    			console.log(parseInt(json["jairitos"])>parseInt(value));
			    			console.log(parseInt(json["jairitos"])+"  "+parseInt(value));
			    			var offsetMillis = end - today;
			    			console.log(offsetMillis);
			    			setTimeout(sendWinner, offsetMillis);
			    				
			    			function sendWinner() {
			    				  alert("gano "+$('#actualWinner').text());
			    				  var winner=document.getElementById("actualWinner").textContent;
			    				  $.post("/superEasy/user/"+winner+"/subCongelados/"+x, {});
			    				}

			        		if(parseInt(value)>x && parseInt(json["jairitos"])>=parseInt(value)){
			        			var newJairitos=parseInt(json["jairitos"])-parseInt(value);
			        			var newCongelados=parseInt(json["jairitosCongelados"])+parseInt(value);
			        			console.log("nuevos jairitos"+newJairitos);
			        			console.log("congelados jairitos"+newCongelados);
			        			$.post("/superEasy/user/"+email+"/Jairitos/"+newJairitos, {});
			        			$.post("/superEasy/user/"+email+"/Congelados/"+newCongelados, {});
			        			var newBid=new Ofertas(1,value,idsubasta,user);
			        			stompClient.send("/app/"+idsubasta,{},JSON.stringify(newBid));
			        			
			        			var loser=document.getElementById("actualWinner").textContent;
//			        			console.log(loser);
			        			$.post("/superEasy/user/"+loser+"/addJairitos/"+x, {});
			        			$.post("/superEasy/user/"+loser+"/subCongelados/"+x, {});
			        			appuser.setJairitosSubasta();
			        		}
			        		else if(parseInt(json["jairitos"])<parseInt(value) && parseInt(value)>x){
			        			alert("no dispone de los jairitos suficientes para ofertar \n " +
			        					"necesita: "+value+"  y dispone de: "+json["jairitos"]);
			        		}
			        		else{
			        			
			        			alert("no se puede ofertar un valor menor o igual a la oferta actual ");
			        		}
			    		}
			    		else{
			    			alert("debe estar logeado para ofertar");
			    		}
						
					});
    		
    		
    	},
    	updateValue:function(newValue){
    		var element= document.getElementById("actualValue");
    		element.innerHTML = "$ "+newValue;
    	}
    }
	
})();