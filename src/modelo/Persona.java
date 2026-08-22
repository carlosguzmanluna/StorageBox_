/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author norki
 */
public abstract class Persona {
 private final String identificacion;
    private String nombreCompleto;
    private String telefono;  
    
protected Persona (String identificacion, String nombreCompleto, String telefono) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
 
    public String getTelefono() {
        return telefono;
    }
    public String SetTelefono(){
        return telefono;
    } 
}


 
