package productos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juanma
 */
public class Herramienta extends Producto{
    /*
    Tipo de herramienta: manual, electrica, gasolina
    Nombre de herramienta: destornillador, taladro, motosierra...
    */
    private String tipo;

    // Constructor
    public Herramienta(String nombre, double precio, double descuento, int cantidadStock, String tipo) {
        super(nombre, precio, descuento, cantidadStock);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    
}
