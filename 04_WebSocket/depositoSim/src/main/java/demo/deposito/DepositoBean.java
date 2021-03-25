/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.deposito;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import demo.deposito.wsocket.WebSocketManager;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 *
 * @author fserna
 */
@Stateless
public class DepositoBean {

    private Double nivel        = 0.0;   // litros que contiene el depósito
    private Double nivel_maximo = 250.0;    // valor máximo del depósito
    private boolean grifoIn     = false;    // estado del grifo de entrada: true=>abierto
    private boolean grifoOut    = false;    // estado del grifo de salida: true=>abierto

    private WebSocketManager websocket;
    

    
    
    @PostConstruct
    public void init(){
        websocket = WebSocketManager.getInstance();
    }
    
    @PreDestroy
    private void sayBye(){
        if (websocket!=null){
            websocket.destroy();  // propaga el evento de "destroy" al elemento
                                 // que gestiona las sesiones websocket, 
                                 // para que puedan ser cerradas convenientemente.
        }
    }




    
    @Schedule (hour="*", minute="*", second="*/5")
    public void updateNivel(){
        if (grifoIn){
            this.nivel += 1.0;
            if (this.nivel > nivel_maximo){
                this.nivel = nivel_maximo;
                grifoIn = false;
            }
        }
        if (grifoOut){
            this.nivel -= 1.1;
            if (this.nivel <0.0){
                this.nivel = 0.0;
                grifoOut=false;
            }
        }

        if (websocket!=null){
            websocket.broadcastValorNumerico(this.nivel);
//System.out.println(this.toString()+"\tNivel: "+nivel+"\t"+new Date().toString());
        }
    }
    
    
    public double getNivel(){
        return this.nivel;
    }
    
    

    
    public boolean isGrifoIn() {
        return grifoIn;
    }

    public void setGrifoIn(boolean _grifoIn) {
        this.grifoIn = _grifoIn;
        if (websocket!=null){
            if (this.grifoIn){
                websocket.broadcastMsg("grifoInABIERTO");
            }else{
                websocket.broadcastMsg("grifoInCERRADO");
            }
        }
    }

    public boolean isGrifoOut() {
        return grifoOut;
    }

    public void setGrifoOut(boolean _grifoOut) {
        this.grifoOut = _grifoOut;
        if (websocket!=null){
            if (this.grifoOut){
                websocket.broadcastMsg("grifoOutABIERTO");
            }else{
                websocket.broadcastMsg("grifoOutCERRADO");
            }
        }
    }
    
    

}
