package demo.ejb;

import demo.Producto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author fserna
 */
@Remote
public interface CarritoRemoto {
    void addProducto(Producto _producto);
    List<Producto> getProductos();
    void procesarPedido();
    Double getImporteTotal();
}
