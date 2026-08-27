package modelo;

import excepciones.DatosInvalidosException;
import excepciones.EstadoNoPermitidoException;
import excepciones.FechaContratoException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {

    private static final double TASA_IMPUESTO = 0.13;
    private static int contador = 1;

    private int numero;
    private Cliente cliente;
    private Espacio espacio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoContrato estado;
    private final List<Servicio> servicios;

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

        cliente.agregarContrato(this);
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

    public List<Servicio> getServicios() {
        return new ArrayList<>(servicios);
    }

   public void agregarServicio(Servicio servicio) {
        if (servicio != null) {
            servicios.add(servicio);
        }
    }

    private boolean esBisiesto(int anio) {
        if (anio % 4 != 0) {
            return false;
        }
        if (anio % 100 != 0) {
            return true;
        }
        return anio % 400 == 0;
    }

    private int diasDelMes(int mes, int anio) {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (mes == 2 && esBisiesto(anio)) {
            return 29;
        }
        return diasPorMes[mes - 1];
    }

    // Convierte una fecha en un numero total de dias, sumando anios, meses y dias completos
    private long convertirADiasTotales(LocalDate fecha) {
        long totalDias = 0;
        int anio = fecha.getYear();
        int mes = fecha.getMonthValue();
        int dia = fecha.getDayOfMonth();

        for (int a = 1; a < anio; a++) {
            if (esBisiesto(a)) {
                totalDias = totalDias + 366;
            } else {
                totalDias = totalDias + 365;
            }
        }

        for (int m = 1; m < mes; m++) {
            totalDias = totalDias + diasDelMes(m, anio);
        }

        totalDias = totalDias + dia;

        return totalDias;
    }

    public long calcularCantidadDias() {
        long diasInicio = convertirADiasTotales(fechaInicio);
        long diasFin = convertirADiasTotales(fechaFin);
        return diasFin - diasInicio;
    }

    // Cada periodo de alquiler equivale a 30 dias o fraccion
    public int calcularCantidadPeriodos() {
        long dias = calcularCantidadDias();
        int periodos = (int) (dias / 30);
        if (dias % 30 != 0) {
            periodos = periodos + 1;
        }
        return periodos;
    }

    public double calcularCostoEspacio() {
        return espacio.getPrecioMensual() * calcularCantidadPeriodos();
    }

    public double calcularCostoServicios() {
        double total = 0;
        for (Servicio servicio : servicios) {
            total = total + servicio.getPrecio();
        }
        return total;
    }

    public double calcularTotal() {
        return calcularCostoEspacio() + calcularCostoServicios();
    }

    // Los precios ya incluyen impuestos, por eso el subtotal se calcula al reves
    public double calcularSubtotal() {
        return calcularTotal() / (1 + TASA_IMPUESTO);
    }

    public double calcularImpuestos() {
        return calcularTotal() - calcularSubtotal();
    }

    public void activar() throws EstadoNoPermitidoException {
        if (estado != EstadoContrato.Pendiente) {
            throw new EstadoNoPermitidoException("Solo se puede activar un contrato pendiente");
        }
        estado = EstadoContrato.Activo;
        espacio.Ocupar();
    }

    public void finalizar() throws EstadoNoPermitidoException {
        if (estado != EstadoContrato.Activo) {
            throw new EstadoNoPermitidoException("Solo se puede finalizar un contrato activo");
        }
        estado = EstadoContrato.Finalizado;
        espacio.Desocupar();
    }

    public void cancelar() throws EstadoNoPermitidoException {
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