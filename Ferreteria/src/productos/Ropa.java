/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos;

/**
 *
 * @author juanma
 */
public class Ropa extends Producto{
    
    /*
    TODA ROPA ES LABORAL PERO DIFERENCIO 2 TIPOS
    Tipo de ropa: De trabajo y epis (equipos de proteccion individual)
    Talla: solo s,m,l o xl. da igual el producto.
    */
    private String tipo;
    private String talla;

    // Constructor
    public Ropa(String nombre, double precio, double descuento, int cantidadStock, String tipo, String talla) {
        super(nombre, precio, descuento, cantidadStock);
        this.tipo = tipo;
        this.talla = talla;
    }

    public String getTipo() {
        return tipo;
    }
    public String getTalla() {
        return talla;
    }
}
