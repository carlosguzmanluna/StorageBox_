/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import excepciones.DatosInvalidosException;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.Empleado;
import modelo.PuestoEmpleado;
/**
 *
 * @author norki
 */
public class EmpleadoController {
    private HashMap<String, Empleado> empleados;
    public EmpleadoController() {
        empleados = new HashMap<>();
    }
    public void agregarEmpleado(Empleado empleado)
            throws DatosInvalidosException {
        if (empleado == null) {
            throw new DatosInvalidosException("El empleado es obligatorio");
        }
        if (empleados.containsKey(empleado.getIdentificacion())) {
            throw new DatosInvalidosException("Ya existe un empleado con esa identificación");
        }
        empleados.put(empleado.getIdentificacion(), empleado);
    }
    public Empleado buscarPorIdentificacion(String identificacion) {
        return empleados.get(identificacion);
    }
    public void actualizarEmpleado(String identificacion,
            String nombreCompleto, String telefono,
            PuestoEmpleado puesto)
            throws DatosInvalidosException {

        Empleado empleado = empleados.get(identificacion);
        if (empleado == null) {
            throw new DatosInvalidosException("No existe el empleado");
        }
        empleado.setNombreCompleto(nombreCompleto);
        empleado.setTelefono(telefono);
        empleado.setPuesto(puesto);
    }
    public void eliminarEmpleado(String identificacion)
            throws DatosInvalidosException {
        Empleado empleado = empleados.get(identificacion);
        if (empleado == null) {
            throw new DatosInvalidosException("No existe el empleado");
        }
        empleados.remove(identificacion);
    }
    public ArrayList<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados.values());
    }
}

