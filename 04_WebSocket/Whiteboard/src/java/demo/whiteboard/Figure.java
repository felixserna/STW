/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.whiteboard;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author fserna
 */
public class Figure {
    private JsonObject json;

    public Figure(JsonObject json) {
        this.json = json;
    }
    
    /**
     * @return the json
     */
    public JsonObject getJson() {
        return json;
    }

    /**
     * @param json the json to set
     */
    public void setJson(JsonObject json) {
        this.json = json;
    }
    
    
    @Override
    public String toString() {
        StringWriter writer = new StringWriter();
        Json.createWriter(writer).write(json);
        return writer.toString();
    }
}
