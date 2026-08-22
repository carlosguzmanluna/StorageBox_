/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import excepciones.DatosInvalidosException;
import excepciones.IdentificacionDuplicadaException;
import java.util.ArrayList;
import modelo.Empleado;
import modelo.PuestoEmpleado;
/**
 *
 * @author norki
 */
public class EmpleadoController {
     private ArrayList<Empleado> empleados;

    public EmpleadoController() {
        empleados = new ArrayList<>();}
    public void agregarEmpleado(Empleado empleado)
            throws DatosInvalidosException, IdentificacionDuplicadaException {
        if (empleado == null) {
            throw new DatosInvalidosException("El empleado no puede ser nulo");
        }
        if (buscarPorIdentificacion(empleado.getIdentificacion()) != null) {
            throw new IdentificacionDuplicadaException("Ya existe un empleado con esa identificación");
        }
        empleados.add(empleado);
    }
    public Empleado buscarPorIdentificacion(String identificacion) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getIdentificacion().equals(identificacion)) {
                return empleados.get(i);
            }
        }
        return null;
    }
    public ArrayList<Empleado> buscarPorNombre(String nombre) {
        ArrayList<Empleado> resultado = new ArrayList<>();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNombreCompleto().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(empleados.get(i));
            }
        }
        return resultado;
    }
    public void actualizarEmpleado(String identificacion,
            String nombreCompleto, String telefono,
            PuestoEmpleado puesto)
            throws DatosInvalidosException {
        Empleado empleado = buscarPorIdentificacion(identificacion);
        if (empleado == null) {
            throw new DatosInvalidosException("No existe un empleado con esa identificación");
        }
        empleado.setNombreCompleto(nombreCompleto);
        empleado.setTelefono(telefono);
        empleado.setPuesto(puesto);
    }
    public void eliminarEmpleado(String identificacion)
            throws DatosInvalidosException {
        Empleado empleado = buscarPorIdentificacion(identificacion);
        if (empleado == null) {
            throw new DatosInvalidosException("No existe un empleado con esa identificación");
        }
        empleados.remove(empleado);
    }
    public ArrayList<Empleado> listarEmpleados() {
        return empleados;
    }
}

