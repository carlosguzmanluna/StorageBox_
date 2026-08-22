/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author norki
 */
public enum PuestoEmpleado {
Administrador(900),
Recepcionista(800),
EncargadoBodega(700),
Mantenimiento(7000);

private final double salario;
PuestoEmpleado(double salario) {
 this.salario = salario;
 
}
public double getSalario() {
        return salario;
    }
}
 

