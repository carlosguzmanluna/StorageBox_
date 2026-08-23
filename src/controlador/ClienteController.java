/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import excepciones.ClienteConContratoException;
import excepciones.DatosInvalidosException;
import excepciones.IdentificacionDuplicadaException;
import modelo.Cliente;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author norki
 */
public class ClienteController {
    private HashMap<String, Cliente> clientes;

    public ClienteController(){
        clientes =new HashMap<>();
    }

    public Cliente agregarCliente(String identificacion, String nombreCompleto, String telefono,
            LocalDate fechaNacimiento, String correoElectronico) throws DatosInvalidosException, IdentificacionDuplicadaException {

        if (clientes.containsKey(identificacion)){
            throw new IdentificacionDuplicadaException("Ya esta registrada esa identificacion");
        }

        Cliente cliente = new Cliente(identificacion, nombreCompleto, telefono,
                fechaNacimiento, correoElectronico);

        clientes.put(identificacion, cliente);
        return cliente;
    }

    public void actualizarCliente(String identificacion, String nombreCompleto,
            String telefono, String correoElectronico) throws DatosInvalidosException {
        Cliente cliente = clientes.get(identificacion);

        if (cliente==null) {
        throw new DatosInvalidosException("No hay un cliente con esa identificacion");
        }

        cliente.setNombreCompleto(nombreCompleto);
        cliente.setTelefono(telefono);
        cliente.setCorreoElectronico(correoElectronico);
    }

    public void eliminarCliente(String identificacion) throws DatosInvalidosException, ClienteConContratoException {
        Cliente cliente = clientes.get(identificacion);

        if(cliente==null){
        throw new DatosInvalidosException("No hay un cliente con esa identificacion");
        }

        if(cliente.tieneContratosActivosOPendientes()){
        throw new ClienteConContratoException( "No se puede eliminar, el cliente posee contratos pendientes o activos");
        }
        clientes.remove(identificacion);
    }

    public Cliente buscarPorIdentificacion(String identificacion){
        return clientes.get(identificacion);
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes.values());
    }
}
  
