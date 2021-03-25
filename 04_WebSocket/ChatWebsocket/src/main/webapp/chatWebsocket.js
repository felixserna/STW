
var wsUri = "ws://" + document.location.host + "/ChatWebsocket/chat";
var webSocket;

var rx          = document.getElementById("rx");
var txField     = document.getElementById("txField");
var registrados = document.getElementById("registrados")
var listaUL = "";

setInterval(showTime, 1000);
openSocket();
     



 function openSocket(){
    if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
       closeSocket();
    }

    webSocket = new WebSocket(wsUri);


    // eventos del websocket ====
    
    webSocket.onopen = function(event){
        if(event.data === undefined)
            return;
    };

    webSocket.onmessage = function(event){
        var json =  JSON.parse(event.data);
        console.log("onMessage: "+event.data);
        
        switch (json.cmd){
            case "chat":
                rx.innerHTML = rx.innerHTML + json.remite+"=> "+json.msg + "<br>";
                break;
                
            case "usuarios":
                listaUL = "<ul>";
                json.registrados.forEach(construyeListaUL);
                listaUL = listaUL + "</ul>";
                registrados.innerHTML = listaUL;
                document.getElementById("numUsuariosRegistrados").innerHTML = json.registrados.length;
                break;
        }
       

    };

    function construyeListaUL (value){
        listaUL = listaUL + "<li>"+value+"</li>";
    }

    webSocket.onclose = function(event){
    };

    webSocket.onerror = function (event){
    };
} //openSocket
           
                


/**
 * Sends the value of the text input to the server
 */
//function sendText(){
//    //var text = messageInput.value;
//    webSocket.send(messageInput.value);
//}

function closeSocket(){
    webSocket.close();
}


function enviarMensaje(_remitente){
    var txMsg = '{"cmd": "chat", "remite": "'+_remitente+'", "msg":"'+txField.value+'"}';
    webSocket.send(txMsg);
    txField.value = ""; 
    console.log("TX: "+txMsg);
}





function getHHMMSS(_ms){
    var date = new Date(_ms);
    var txt = "";
    
    if (date.getHours()<10){
        txt= "0";
    }
    txt = txt + date.getHours()+":";
    if (date.getMinutes()<10){
        txt = txt + "0";
    }
    txt = txt + date.getMinutes()+":";
    if (date.getSeconds()<10){
        txt = txt + "0";
    }
    txt = txt + date.getSeconds();
  
    return txt;
}

    
function getDDMMYYYY(_ms){
    var date = new Date(_ms);
    var txt = "";
    
    if (date.getDate()<10){
        txt = "0";
    }
    txt = txt + date.getDate()+"/";
    if ((date.getMonth()+1)<10){
        txt = txt +"0";
    }
    txt = txt + (date.getMonth()+1)+"/"+date.getFullYear();
    return txt;
}


function showTime(){
    var msNow = new Date().getTime();
    document.getElementById("queHoraEs").innerHTML = getDDMMYYYY(msNow)+" @ "+getHHMMSS(msNow);
}

