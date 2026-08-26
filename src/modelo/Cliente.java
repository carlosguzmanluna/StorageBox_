/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import excepciones.DatosInvalidosException;
import modelo.Persona;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author norki
 */
public class Cliente extends Persona {
    
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    private final List<Contrato> contratos;

    public Cliente(String identificacion, String nombreCompleto, String telefono,
        LocalDate fechaNacimiento, String correoElectronico) throws DatosInvalidosException{
        super(identificacion, nombreCompleto, telefono);
     
        //Aqui piden que los campos no esten vacion
        if(identificacion == null|| identificacion.equals("") ){
            throw new DatosInvalidosException("La identificacion es obligatoria");
        }
        
        if(nombreCompleto == null || nombreCompleto.equals("")){
            throw new DatosInvalidosException("El nombre es obligatorio");
        }
        if(telefono == null || telefono.equals("")){
            throw new DatosInvalidosException("El ntelefono es obligatorio");
        }
        setFechaNacimiento(fechaNacimiento);
        setCorreoElectronico(correoElectronico);
        this.contratos = new ArrayList<>();     
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) throws DatosInvalidosException{
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            throw new DatosInvalidosException("La fecha de nacimiento no es valida"); //se encarga de que la fecha de nacimiento no sea futura
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCorreoElectronico(String correoElectronico)throws DatosInvalidosException{
        if (correoElectronico == null || correoElectronico.equals("")) {
            throw new DatosInvalidosException("El correo electrónico es obligatorio"); //porque el correo no puede ser un campo vacio
        }
        this.correoElectronico = correoElectronico;
    }
    public void agregarContrato(Contrato contrato) {
        contratos.add(contrato);
    }
    public int calcularEdad(){
        return Period.between(fechaNacimiento,LocalDate.now()).getYears();
    }
    public boolean tieneContratosActivosOPendientes() {
    for (int i = 0; i < contratos.size(); i++) {
        Contrato contrato = contratos.get(i);
        EstadoContrato estado = contrato.getEstado();
        if (estado == EstadoContrato.Pendiente || estado == EstadoContrato.Activo) {
            return true;
        }
    }
    return false;
}
}
