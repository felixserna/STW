/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.whiteboard;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author fserna
 */
public class FigureEncoder implements Encoder.Text<Figure> {
    
    @Override
    public String encode(Figure figure) throws EncodeException {
        return figure.getJson().toString();
    }

    @Override
    public void init(EndpointConfig ec) {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
