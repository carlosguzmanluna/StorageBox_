package controlador;

import excepciones.DatosInvalidosException;
import excepciones.EstadoNoPermitidoException;
import excepciones.FechaContratoException;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Espacio;
import modelo.EstadoContrato;
import modelo.TipoEspacio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContratoController {

    private LinkedList<Contrato> contratos;
    private ClienteController clienteController;
    private EspacioController espacioController;

    public ContratoController(ClienteController clienteController, EspacioController espacioController) {
        this.contratos = new LinkedList<>();
        this.clienteController = clienteController;
        this.espacioController = espacioController;
    }

    public ArrayList<Espacio> buscarEspaciosDisponibles(TipoEspacio tipo, LocalDate fechaInicio, LocalDate fechaFin) {
        ArrayList<Espacio> candidatos = espacioController.buscarDisponiblesPorTipo(tipo);
        ArrayList<Espacio> resultado = new ArrayList<>();

        for (int i = 0; i < candidatos.size(); i++) {
            Espacio espacio = candidatos.get(i);
            if (!existeConflictoDeFechas(espacio, fechaInicio, fechaFin)) {
                resultado.add(espacio);
            }
        }
        return resultado;
    }

    private boolean existeConflictoDeFechas(Espacio espacio, LocalDate fechaInicio, LocalDate fechaFin) {
        for (int i = 0; i < contratos.size(); i++) {
            Contrato c = contratos.get(i);
            if (c.getEspacio() == espacio
                    && c.getEstado() != EstadoContrato.Cancelado
                    && c.getEstado() != EstadoContrato.Finalizado) {

                boolean seSolapan = fechaInicio.isBefore(c.getFechaFin())
                        && fechaFin.isAfter(c.getFechaInicio());

                if (seSolapan) {
                    return true;
                }
            }
        }
        return false;
    }

    public Contrato crearContrato(String identificacionCliente, TipoEspacio tipoEspacio,
            LocalDate fechaInicio, LocalDate fechaFin)
            throws DatosInvalidosException, FechaContratoException {

        Cliente cliente = clienteController.buscarPorIdentificacion(identificacionCliente);
        if (cliente == null) {
            throw new DatosInvalidosException("No existe un cliente con esa identificación");
        }

        ArrayList<Espacio> disponibles = buscarEspaciosDisponibles(tipoEspacio, fechaInicio, fechaFin);
        if (disponibles.isEmpty()) {
            throw new DatosInvalidosException("No hay espacios disponibles de ese tipo en esas fechas");
        }

        Espacio espacioAsignado = disponibles.get(0);

        Contrato contrato = new Contrato(cliente, espacioAsignado, fechaInicio, fechaFin);
        contratos.add(contrato);
        return contrato;
    }

    public void activarContrato(int numero) throws DatosInvalidosException, EstadoNoPermitidoException {
        Contrato contrato = buscarPorNumero(numero);
        if (contrato == null) {
            throw new DatosInvalidosException("No existe un contrato con ese número");
        }
        contrato.activar();
    }

    public void finalizarContrato(int numero) throws DatosInvalidosException, EstadoNoPermitidoException {
        Contrato contrato = buscarPorNumero(numero);
        if (contrato == null) {
            throw new DatosInvalidosException("No existe un contrato con ese número");
        }
        contrato.finalizar();
    }

    public void cancelarContrato(int numero) throws DatosInvalidosException, EstadoNoPermitidoException {
        Contrato contrato = buscarPorNumero(numero);
        if (contrato == null) {
            throw new DatosInvalidosException("No existe un contrato con ese número");
        }
        contrato.cancelar();
    }

    public Contrato buscarPorNumero(int numero) {
        for (int i = 0; i < contratos.size(); i++) {
            if (contratos.get(i).getNumero() == numero) {
                return contratos.get(i);
            }
        }
        return null;
    }

    public List<Contrato> listarContratos() {
        return new ArrayList<>(contratos);
    }
}