/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author Jos_s
 */
public class producto {
    private int id;
    private String nombre;
    private String tipo;
    private String descripcion;
    private int valorNutricional;
    
    public producto(int id, String nombre, String tipo, String descripcion, int valorNutricional){
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.valorNutricional = valorNutricional; 
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getValorNutricional() {
        return valorNutricional;
    }
    
}
