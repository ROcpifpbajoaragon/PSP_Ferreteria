/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos;

/**
 *
 * @author juanma
 */
public class Producto {
    
    /*    
    El modificador protected en Java indica que un miembro (atributo o método) 
    de una clase es accesible dentro del mismo paquete o por clases derivadas
    (subclases) de esa clase, ya sea dentro del mismo paquete 
    o en cualquier otro paquete.
    */
    protected String nombre;
    protected double precio;
    /*
    Crear interfaz para modificar los descuentos en funcion de la cantidad que 
    compre el cliente
    */
    protected double descuento;
    protected int cantidadStock;
       
    
    // Constructor
    public Producto(String nombre, double precio, double descuento, int cantidadStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.descuento = descuento;
    }

    // Métodos para acceder y modificar atributos
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    public double getDescuento() {
        return precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void actualizarCantidadStock(int nuevaCantidad) {
        cantidadStock = nuevaCantidad;
    }
}