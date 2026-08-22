/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import excepciones.DatosInvalidosException;
import excepciones.EspacioDuplicadoException;
import excepciones.EspacioOcupadoException;
import modelo.Espacio;
import modelo.EstadoEspacio;
import modelo.TipoEspacio;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author norki
 */
public class EspacioController {
 private LinkedList<Espacio> espacios;  

public EspacioController(){
    espacios = new LinkedList<>();
} 
public void agregarEspacio(Espacio espacio)
        throws DatosInvalidosException, EspacioDuplicadoException{
    
}
}

