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
Administrador(950000),
Recepcionista(700000),
EncargadoBodega(650000),
Mantenimiento(600000),
OperarioCarga(575000);

private final double salario;
PuestoEmpleado(double salario) {
 this.salario = salario;
 
}
public double getSalario() {
        return salario;
    }
}
 

