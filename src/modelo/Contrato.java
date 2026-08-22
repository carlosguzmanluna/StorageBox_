/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import excepciones.DatosInvalidosException;
import excepciones.FechaContratoException;
import excepciones.EstadoNoPermitidoException;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author norki
 */
public class Contrato {
    private static int contador = 1;
    private int numero;
    private Cliente cliente;
    private Espacio espacio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoContrato estado;
    private ArrayList<Servicio> servicios;

    public Contrato(Cliente cliente, Espacio espacio,
            LocalDate fechaInicio, LocalDate fechaFin)
            throws DatosInvalidosException, FechaContratoException {
        if (cliente == null) {
            throw new DatosInvalidosException("El cliente es obligatorio");
        }
        if (espacio == null) {
            throw new DatosInvalidosException("El espacio es obligatorio");
        }
        if (fechaInicio == null) {
            throw new FechaContratoException("La fecha de inicio es obligatoria");
        }
        if (fechaFin == null) {
            throw new FechaContratoException("La fecha final es obligatoria");
        }
        if (!fechaFin.isAfter(fechaInicio)) {
            throw new FechaContratoException("La fecha final debe ser posterior a la fecha inicial");
        }
        numero = contador++;
        this.cliente = cliente;
        this.espacio = espacio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = EstadoContrato.Pendiente;
        this.servicios = new ArrayList<>();
    }
    public int getNumero() {
        return numero;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Espacio getEspacio() {
        return espacio;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public EstadoContrato getEstado() {
        return estado;
    }
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    public void agregarServicio(Servicio servicio)
            throws DatosInvalidosException {

        if (servicio == null) {
            throw new DatosInvalidosException(
                    "El servicio no puede ser nulo");
        }
        servicios.add(servicio);
    }
    public double calcularCostoEspacio(int periodos) {
        return espacio.getPrecioMensual() * periodos;
    }
    public double calcularCostoServicios() {
        double total = 0;
        for (Servicio servicio : servicios) {
            total = total + servicio.getPrecio();
        }
        return total;
    }
    public double calcularSubtotal(int periodos) {

        return calcularCostoEspacio(periodos)
                + calcularCostoServicios();
    }
    public double calcularImpuestos(int periodos, double porcentaje) {
        return calcularSubtotal(periodos) * porcentaje;
    }
    public double calcularTotal(int periodos, double porcentaje) {

        return calcularSubtotal(periodos)
                + calcularImpuestos(periodos, porcentaje);
    }
  public void activar()
        throws EstadoNoPermitidoException {

    if (estado != EstadoContrato.Pendiente) {
        throw new EstadoNoPermitidoException("Solo se puede activar un contrato pendiente");
    }

    estado = EstadoContrato.Activo;
    espacio.Ocupar();
}
    public void finalizar()
        throws EstadoNoPermitidoException {
    if (estado != EstadoContrato.Activo) {
        throw new EstadoNoPermitidoException("Solo se puede finalizar un contrato activo");
    }
    estado = EstadoContrato.Finalizado;
    espacio.Desocupar();
}
    public void cancelar()
        throws EstadoNoPermitidoException {
    if (estado != EstadoContrato.Pendiente) {
        throw new EstadoNoPermitidoException("Solo se puede cancelar un contrato pendiente");
    }
    estado = EstadoContrato.Cancelado;
    espacio.Desocupar();
}
    @Override
    public String toString() {
        return "Contrato " + numero;
    }
}

    

