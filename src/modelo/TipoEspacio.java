package modelo;

public enum TipoEspacio {
    PEQUENO(5, 25000),
    MEDIANO(10, 45000),
    GRANDE(20, 70000);

    private final double metrosCuadrados;    
    private final double precioMensual;    

    TipoEspacio(double metrosCuadrados, double precioMensual) {
        this.metrosCuadrados = metrosCuadrados;
        this.precioMensual = precioMensual;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }
}