package controlador;
import excepciones.ClienteConContratoException;
import excepciones.DatosInvalidosException;
import excepciones.EspacioDuplicadoException;
import excepciones.EspacioOcupadoException;
import excepciones.EstadoNoPermitidoException;
import excepciones.FechaContratoException;
import excepciones.IdentificacionDuplicadaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Empleado;
import modelo.Espacio;
import modelo.EstadoContrato;
import modelo.EstadoEspacio;
import modelo.PuestoEmpleado;
import modelo.Servicio;
import modelo.TipoEspacio;
/**
 *
 * @author maria
 */
public class StorageBoxController {
    private final HashMap<String, Cliente> clientes;
    private final HashMap<String, Empleado> empleados;
    private final ArrayList<Espacio> espacios;
    private final ArrayList<Servicio> servicios;
    private final LinkedList<Contrato> contratos;

    public StorageBoxController() {
        clientes = new HashMap<>();
        empleados = new HashMap<>();
        espacios = new ArrayList<>();
        servicios = new ArrayList<>();
        contratos = new LinkedList<>();
    }
    public Cliente agregarCliente(String identificacion, String nombreCompleto,
            String telefono, LocalDate fechaNacimiento,
            String correoElectronico)
            throws DatosInvalidosException,
            IdentificacionDuplicadaException {

        if (clientes.containsKey(identificacion)) {
            throw new IdentificacionDuplicadaException(
                    "Ya esta registrada esa identificacion");}
        Cliente cliente = new Cliente(identificacion, nombreCompleto,
                telefono, fechaNacimiento, correoElectronico);

        clientes.put(identificacion, cliente);
        return cliente;
    }
    public void actualizarCliente(String identificacion,
            String nombreCompleto, String telefono,
            String correoElectronico)
            throws DatosInvalidosException {

        Cliente cliente = clientes.get(identificacion);

        if (cliente == null) {
            throw new DatosInvalidosException("No hay un cliente con esa identificacion");
        }
        cliente.setNombreCompleto(nombreCompleto);
        cliente.setTelefono(telefono);
        cliente.setCorreoElectronico(correoElectronico);
    }
    public void eliminarCliente(String identificacion)
            throws DatosInvalidosException,
            ClienteConContratoException {

        Cliente cliente = clientes.get(identificacion);

        if (cliente == null) {
            throw new DatosInvalidosException("No hay un cliente con esa identificacion");
        }
        if (cliente.tieneContratosActivosOPendientes()) {
            throw new ClienteConContratoException( "No se puede eliminar, el cliente posee contratos pendientes o activos");
        }
        clientes.remove(identificacion);
    }
    public Cliente buscarPorIdentificacion(String identificacion) {
        return clientes.get(identificacion);
    }
    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes.values());
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

    public Empleado buscarEmpleadoPorIdentificacion(String identificacion) {
        return empleados.get(identificacion);
    }
    public ArrayList<Empleado> buscarEmpleadosPorNombre(String nombre) {
    ArrayList<Empleado> resultados = new ArrayList<>();
    ArrayList<Empleado> lista =
            new ArrayList<>(empleados.values());
    for (int i = 0; i < lista.size(); i++) {
        Empleado empleado = lista.get(i);
        if (empleado.getNombreCompleto().contains(nombre)) {
            resultados.add(empleado);
        }
    }
    return resultados;
}
    public double obtenerSalario(String puesto) {
        return switch (puesto) {
            case "Administrador" -> PuestoEmpleado.Administrador.getSalario();
            case "Recepcionista" -> PuestoEmpleado.Recepcionista.getSalario();
            case "EncargadoBodega" -> PuestoEmpleado.EncargadoBodega.getSalario();
            case "Mantenimiento" -> PuestoEmpleado.Mantenimiento.getSalario();
            default -> PuestoEmpleado.OperarioCarga.getSalario();
        };
}
    public PuestoEmpleado obtenerPuesto(String puesto) {
    return PuestoEmpleado.valueOf(puesto);
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

    public void agregarEspacio(Espacio espacio)
            throws DatosInvalidosException,
            EspacioDuplicadoException {

        if (espacio == null) {
            throw new DatosInvalidosException("El espacio no puede ser nulo");
        }

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
            throw new DatosInvalidosException("No existe un espacio con ese número");
        }
        espacio.setTipo(tipo);
        espacio.setMetrosCuadrados(metrosCuadrados);
        espacio.setPrecioMensual(precioMensual);
    }

    public void eliminarEspacio(int numero)
            throws DatosInvalidosException,
            EspacioOcupadoException {

        Espacio espacio = buscarPorNumero(numero);

        if (espacio == null) {
            throw new DatosInvalidosException("No existe un espacio con ese número");
        }

        if (espacio.getEstado() == EstadoEspacio.Ocupado) {
            throw new EspacioOcupadoException("No se puede eliminar un espacio ocupado");
        }

        espacios.remove(espacio);
    }

    public ArrayList<Espacio> buscarDisponiblesPorTipo(TipoEspacio tipo) {
        ArrayList<Espacio> disponibles = new ArrayList<>();
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getTipo() == tipo
                    && espacios.get(i).getEstado()
                    == EstadoEspacio.Disponible) {
                disponibles.add(espacios.get(i));
            }
        }
        return disponibles;
    }
        public Espacio obtenerPrimerEspacioDisponible(TipoEspacio tipo,
            LocalDate fechaInicio, LocalDate fechaFin) {
        ArrayList<Espacio> disponibles =
                buscarEspaciosDisponibles(tipo, fechaInicio, fechaFin);
        if (disponibles.isEmpty()) {
            return null;
        }
        return disponibles.get(0);
    }

    public ArrayList<Espacio> listarEspacios() {
        return espacios;
    }
   public Servicio agregarServicio(String nombre, String descripcion,
        double precio) throws DatosInvalidosException {
    Servicio servicio = new Servicio(nombre, descripcion, precio);
    servicios.add(servicio);
    return servicio;
}

    public Servicio buscarPorCodigo(int codigo) {
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getCodigo() == codigo) {
                return servicios.get(i);
            }
        }

        return null;
    }

    public void actualizarServicio(int codigo,
            String descripcion, double precio)
            throws DatosInvalidosException {
        Servicio servicio = buscarPorCodigo(codigo);

        if (servicio == null) {
            throw new DatosInvalidosException("No existe un servicio con ese código");
        }

        servicio.setDescripcion(descripcion);
        servicio.setPrecio(precio);
    }

    public void eliminarServicio(int codigo)
            throws DatosInvalidosException {

        Servicio servicio = buscarPorCodigo(codigo);

        if (servicio == null) {
            throw new DatosInvalidosException("No existe un servicio con ese código");
        }
        servicios.remove(servicio);
    }

    public ArrayList<Servicio> listarServicios() {
        return servicios;
    }

    public ArrayList<Espacio> buscarEspaciosDisponibles(
            TipoEspacio tipo, LocalDate fechaInicio,
            LocalDate fechaFin) {

        ArrayList<Espacio> candidatos =
                buscarDisponiblesPorTipo(tipo);
        ArrayList<Espacio> resultado = new ArrayList<>();
        for (int i = 0; i < candidatos.size(); i++) {

            Espacio espacio = candidatos.get(i);
            if (!existeConflictoDeFechas(
                    espacio, fechaInicio, fechaFin)) {

                resultado.add(espacio);
            }
        }

        return resultado;
        
    }
        public int contarEspaciosDisponiblesPorTipo(TipoEspacio tipo) {
        return buscarDisponiblesPorTipo(tipo).size();
    }

    private boolean existeConflictoDeFechas(
            Espacio espacio, LocalDate fechaInicio,
            LocalDate fechaFin) {
        for (int i = 0; i < contratos.size(); i++) {
            Contrato c = contratos.get(i);
            if (c.getEspacio() == espacio
                    && c.getEstado() != EstadoContrato.Cancelado
                    && c.getEstado() != EstadoContrato.Finalizado) {
                boolean empiezaAntesDeQueTermineElOtro =
                        fechaInicio.isBefore(c.getFechaFin());
                boolean terminaDespuesDeQueEmpieceElOtro =
                        fechaFin.isAfter(c.getFechaInicio());
                if (empiezaAntesDeQueTermineElOtro
                        && terminaDespuesDeQueEmpieceElOtro) {

                    return true;
                }
            }
        }

        return false;
    }

    public Contrato crearContrato(
            String identificacionCliente,
            TipoEspacio tipoEspacio,
            LocalDate fechaInicio,
            LocalDate fechaFin)
            throws DatosInvalidosException,
            FechaContratoException {

        Cliente cliente =
                buscarPorIdentificacion(identificacionCliente);

        if (cliente == null) {
            throw new DatosInvalidosException("No existe un cliente con esa identificación");
        }

        ArrayList<Espacio> disponibles =
                buscarEspaciosDisponibles(
                        tipoEspacio, fechaInicio, fechaFin);

        if (disponibles.isEmpty()) {
            throw new DatosInvalidosException("No hay espacios disponibles de ese tipo en esas fechas");
        }
        Espacio espacioAsignado = disponibles.get(0);

        Contrato contrato = new Contrato(
                cliente, espacioAsignado, fechaInicio, fechaFin);

        contratos.add(contrato);
        

        return contrato;
    }

    public void activarContrato(int numero)
            throws DatosInvalidosException,
            EstadoNoPermitidoException {
        Contrato contrato = buscarContratoPorNumero(numero);
        if (contrato == null) {
            throw new DatosInvalidosException( "No existe un contrato con ese número");
        }
        contrato.activar();
    }

    public void finalizarContrato(int numero)
            throws DatosInvalidosException,
            EstadoNoPermitidoException {
        Contrato contrato = buscarContratoPorNumero(numero);
        if (contrato == null) {
            throw new DatosInvalidosException("No existe un contrato con ese número");
        }

        contrato.finalizar();
    }
    public void cancelarContrato(int numero)
            throws DatosInvalidosException,
            EstadoNoPermitidoException {

        Contrato contrato = buscarContratoPorNumero(numero);
        if (contrato == null) {
            throw new DatosInvalidosException("No existe un contrato con ese número");
        }
        contrato.cancelar();
    }
    public Contrato buscarContratoPorNumero(int numero) {
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
    public ArrayList<Espacio> filtrarEspacios(Integer numeroFiltro, TipoEspacio tipoFiltro, EstadoEspacio estadoFiltro, Double precioDesde, Double precioHasta) {
    ArrayList<Espacio> resultados = new ArrayList<>();
    
    for (int i = 0; i < espacios.size(); i++) {
        Espacio esp = espacios.get(i);
        if (numeroFiltro != null && esp.getNumero() != numeroFiltro) {
            continue;
        }
        if (tipoFiltro != null && esp.getTipo() != tipoFiltro) {
            continue;
        }
        if (estadoFiltro != null && esp.getEstado() != estadoFiltro) {
            continue;
        }
        if (precioDesde != null && esp.getPrecioMensual() < precioDesde) {
            continue;
        }
        if (precioHasta != null && esp.getPrecioMensual() > precioHasta) {
            continue;
        }
        resultados.add(esp);
    }
    
    return resultados;
}    
}

