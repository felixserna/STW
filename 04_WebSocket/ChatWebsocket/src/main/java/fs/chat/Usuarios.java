/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fs.chat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;

/**
 *
 * @author fserna
 */
@Stateless
public class Usuarios {
    private Set<String> nombres = new HashSet();
    
    
    public void addNombre (String _nombre){
        nombres.add(_nombre.toLowerCase());
    }
    
    public boolean existeNombre (String _nombre){
        return nombres.contains(_nombre.toLowerCase());
    }
    
    
    public void eliminarNombre (String _nombre){
        nombres.remove(_nombre.toLowerCase());
    }
    
    
    public List<String> getNombres(){
        return new ArrayList<>(nombres);
    }

}
