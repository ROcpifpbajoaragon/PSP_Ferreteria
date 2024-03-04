/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos;

/**
 *
 * @author juanma
 */
public class Consumibles extends Producto{
    
    /*
    Tipo: Quimico, tornilleria, abrasivos y lijas
    */
    private String tipo;


    // Constructor
    public Consumibles(String nombre, double precio, double descuento, int cantidadStock, String tipo) {
        super(nombre, precio, descuento, cantidadStock);
        this.tipo = tipo;

    }

    public String getTipo() {
        return tipo;
    }

}

