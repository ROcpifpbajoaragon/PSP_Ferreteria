package tienda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanma
 */
//CREAR LA TIENDA EN SERVIDOR NO EN HILO YA QUE SI LA CREO DE NUEVO EN CADA HILO
//CADA CLIENTE TENDRÍA UNA TIENDA DISTINTA.
public class Tienda {

    private List<Producto> inventario;

    public Tienda() {
        inventario = new ArrayList<>();
        //Productos de inicio
        inventario.add(new Producto("Destornillador", 10));
        inventario.add(new Producto("Taladro", 5));
        inventario.add(new Producto("Motosierra", 3));
        inventario.add(new Producto("Cortacesped", 7));
    }

    public String infoInventario() {
        StringBuilder info = new StringBuilder();
        for (Producto prod : inventario) {
           info.append(prod.getNombre()).append(", ").append(prod.getStock()).append(" unidades, ");
        }
        return info.toString();
    }
    
    
    //Poner solo 1 RETURN
    public synchronized boolean realizarCompra(String nombreProducto, int cantidad) {
        boolean a = false;
        for (Producto prod : inventario) {
            if (prod.getNombre().equalsIgnoreCase(nombreProducto)) {
                if (prod.getStock() >= cantidad) {
                    prod.reducirStock(cantidad);
                    a = true; // Compra exitosa
                } else {
                    a = false; // No hay suficiente stock
                }
            }
        }
        return a; // Producto no encontrado
    }

    public boolean validarProducto(String nombreProducto) {
        boolean a = false;
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                a = true; // El producto existe en el inventario
            }
        }
        return a; // El producto no existe en el inventario
    }

}
