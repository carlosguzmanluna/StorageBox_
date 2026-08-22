/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import excepciones.DatosInvalidosException;
/**
 *
 * @author norki
 */
public class Servicio {
   
    private static int contador = 1;
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;

    public Servicio(String nombre, String descripcion, double precio)
            throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del servicio es obligatorio" );}
        if (precio < 0) {
            throw new DatosInvalidosException("El precio no puede ser negativo");
        }
        this.codigo = contador++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setDescripcion(String descripcion)
            throws DatosInvalidosException {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new DatosInvalidosException("La descripción del servicio es obligatoria.");
        }
        this.descripcion = descripcion;
    }
    public void setPrecio(double precio)
            throws DatosInvalidosException {
        if (precio < 0) {
            throw new DatosInvalidosException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}