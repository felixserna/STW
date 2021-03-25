/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ejb;


import demo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;

/**
 *
 * @author Usuario
 */
@Stateful
public class CarritoBean implements CarritoRemoto  {

    private List<Producto> productos = new ArrayList();
    
    
    @PostConstruct
    public void sayHello(){
        System.out.println("==================>> Carrito CREADO");
    }
    
     @PreDestroy
    public void sayBye(){
        System.out.println("==================>> Carrito DESTRUIDO");
    }
    
    @Override
    public void addProducto(Producto _producto) {
        this.productos.add(_producto);
    }

    @Override
    public List<Producto> getProductos() {
        return this.productos;
    }
    
    @Override
    public void procesarPedido() {
        this.productos.clear();
        System.out.println("==================>> Carrito PROCESADO");
    }

    @Override
    public Double getImporteTotal() {
        Double total = 0.0;
        for (Producto p: this.productos){
            total+= p.getImporte();
        }
        return total;
    }
    
}
