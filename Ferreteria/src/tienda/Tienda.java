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
        this.inventario = new ArrayList<>();
        //Productos de inicio
        inventario.add(new Producto("Destornillador", 10));
        inventario.add(new Producto("Taladro", 5));
        inventario.add(new Producto("Motosierra", 3));
        inventario.add(new Producto("Cortacesped", 7));
    }

    /*    
 public synchronized List<String> obtenerProductosDisponibles() {
        List<String> productosDisponibles = new ArrayList<>();
        for (Producto producto : inventario) {
            if (producto.getStock() > 0) {
                String infoProducto = producto.getNombre() + " - " + producto.getStock() + " unidades";
                productosDisponibles.add(infoProducto);
            }
        }
        return productosDisponibles;
    }
     */
    public String obtenerDatosProductos() {
        StringBuilder datos = new StringBuilder();
        for (Producto producto : inventario) {
            datos.append("Nombre: ").append(producto.getNombre())
                    .append(", Stock: ").append(producto.getStock())
                    .append("\n");
        }
        return datos.toString();
    }

    public String obtenerDatosInventario() {
        StringBuilder datos = new StringBuilder();
        for (Producto producto : inventario) {
            datos.append(producto.getNombre()).append(", ").append(producto.getStock()).append(" unidades, ");
        }
        // Eliminar la coma final y el espacio
        if (datos.length() > 0) {
            datos.delete(datos.length() - 2, datos.length());
        }
        return datos.toString();
    }

}
