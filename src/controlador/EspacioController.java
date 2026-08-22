/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import excepciones.DatosInvalidosException;
import excepciones.EspacioDuplicadoException;
import excepciones.EspacioOcupadoException;
import java.util.ArrayList;
import modelo.Espacio;
import modelo.EstadoEspacio;
import modelo.TipoEspacio;
/**
 *
 * @author norki
 */
public class EspacioController {
 private ArrayList<Espacio> espacios;
 
public EspacioController(){
    espacios = new ArrayList<>();
}
public void agregarEspacio(Espacio espacio)
        throws DatosInvalidosException,EspacioDuplicadoException{
    
if(espacio==null){
throw new DatosInvalidosException("El espacio no puede ser nulo");}
        if (buscarPorNumero(espacio.getNumero()) != null) {
            throw new EspacioDuplicadoException("Ya existe un espacio con ese número");
        }
        espacios.add(espacio);
    }
    public Espacio buscarPorNumero(int numero) {
    for (int i = 0; i < espacios.size(); i++) {
        if (espacios.get(i).getNumero() == numero) {
            return espacios.get(i);
        }
    }
    return null;
}
     public void actualizarEspacio(int numero, TipoEspacio tipo,
            double metrosCuadrados, double precioMensual)
            throws DatosInvalidosException {
        Espacio espacio = buscarPorNumero(numero);
        if (espacio == null) {
            throw new DatosInvalidosException(
                    "No existe un espacio con ese número");
        }
        espacio.setTipo(tipo);
        espacio.setMetrosCuadrados(metrosCuadrados);
        espacio.setPrecioMensual(precioMensual);
    }
    public void eliminarEspacio(int numero)
            throws DatosInvalidosException, EspacioOcupadoException {
        Espacio espacio = buscarPorNumero(numero);
        if (espacio == null) {
            throw new DatosInvalidosException("No existe un espacio con ese número");
        }
        if (espacio.getEstado() == EstadoEspacio.OCUPADO) {
            throw new EspacioOcupadoException("No se puede eliminar un espacio ocupado");
        }

        espacios.remove(espacio);
    }

    public ArrayList<Espacio> listarEspacios() {
        return espacios;
    }
}