package modelo;

import excepciones.DatosInvalidosException;

public class Empleado extends Persona {
    private PuestoEmpleado puesto;
    private double salario;

    public Empleado(String identificacion, String nombreCompleto, String telefono,
                     PuestoEmpleado puesto) throws DatosInvalidosException {
        super(identificacion, nombreCompleto, telefono);

        if (puesto == null) {
            throw new DatosInvalidosException("El puesto es obligatorio");
        }

        this.puesto = puesto;
        this.salario = puesto.getSalario();
    }

    public PuestoEmpleado getPuesto() {
        return puesto;
    }

    public void setPuesto(PuestoEmpleado puesto) throws DatosInvalidosException {
        if (puesto == null) {
            throw new DatosInvalidosException("El puesto es obligatorio");
        }
        this.puesto = puesto;
        this.salario = puesto.getSalario();
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return getIdentificacion() + " - " + getNombreCompleto();
    }
}