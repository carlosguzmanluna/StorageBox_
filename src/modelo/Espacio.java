package modelo;

import excepciones.DatosInvalidosException;

public class Espacio {
    private int numero;
    private TipoEspacio tipo;
    private double metrosCuadrados;
    private double precioMensual;
    private EstadoEspacio estado;

    public Espacio(int numero, TipoEspacio tipo) throws DatosInvalidosException {
        if (numero <= 0) {
            throw new DatosInvalidosException("El número de espacio no es válido");
        }
        if (tipo == null) {
            throw new DatosInvalidosException("El tipo de espacio es obligatorio");
        }

        this.numero = numero;
        this.tipo = tipo;
        this.metrosCuadrados = tipo.getMetrosCuadrados();
        this.precioMensual = tipo.getPrecioMensual();
        this.estado = EstadoEspacio.DISPONIBLE;
    }

    public int getNumero() { return numero; }
    public TipoEspacio getTipo() { return tipo; }

    public void setTipo(TipoEspacio tipo) throws DatosInvalidosException {
        if (tipo == null) {
            throw new DatosInvalidosException("El tipo de espacio es obligatorio");
        }
        this.tipo = tipo;
        this.metrosCuadrados = tipo.getMetrosCuadrados();
        this.precioMensual = tipo.getPrecioMensual();
    }

    public double getMetrosCuadrados() { return metrosCuadrados; }

    public void setMetrosCuadrados(double metrosCuadrados) throws DatosInvalidosException {
        if (metrosCuadrados <= 0) {
            throw new DatosInvalidosException("El tamaño no es válido");
        }
        this.metrosCuadrados = metrosCuadrados;
    }

    public double getPrecioMensual() { return precioMensual; }

    public void setPrecioMensual(double precioMensual) throws DatosInvalidosException {
        if (precioMensual < 0) {
            throw new DatosInvalidosException("El precio no puede ser negativo");
        }
        this.precioMensual = precioMensual;
    }

    public EstadoEspacio getEstado() { return estado; }

    public void marcarOcupado() { this.estado = EstadoEspacio.OCUPADO; }
    public void marcarDisponible() { this.estado = EstadoEspacio.DISPONIBLE; }

    @Override
    public String toString() {
        return numero + " - " + tipo + " (" + estado + ")";
    }
}