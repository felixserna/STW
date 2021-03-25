package fs.chat.websocket;


import fs.chat.Usuarios;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author fserna
 */

@ServerEndpoint("/chat")
@Stateless
public class WebSocketManager {


    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    @EJB Usuarios usuariosRegistrados;

    public WebSocketManager(){
    }
    
    @OnOpen
    public void onOpen(Session _session){
        sessions.add(_session);
        
        this.publishUsuariosRegistrados(usuariosRegistrados.getNombres());
    }
     
    @OnMessage
    public String onMessage(String _message) {
        
        // broadcast del mensaje recibido
        for (Session s: sessions){
            try {
                s.getBasicRemote().sendText(_message);
            } catch (IOException ex) {
              
            }
        }
        return null;
    }
    
    @OnClose
    public void onClose(Session _session){
        sessions.remove(_session);
    }
    
    
    public void sendToClients (String _json){
        //System.out.println(_json);
        try {
            for (Session session : sessions) {
                session.getBasicRemote().sendText(_json);
            }
        } catch (IOException ex) {
        }
    }    
    
    
    public void publishUsuariosRegistrados(List<String> _uu){
        String json = "{\"cmd\": \"usuarios\", \"registrados\": [";

        int n= 0;
        for (String u: _uu){
            if (n>0){
                json += ", ";
            }
            n++;
            json += "\""+u+"\"";
        }
        json += "]}";
//System.out.println(json);
        try {
            for (Session session : sessions) {
                session.getBasicRemote().sendText(json);
            }
        } catch (IOException ex) {
        }
    }
}
