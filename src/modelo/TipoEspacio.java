package modelo;

public enum TipoEspacio {
    PEQUENO(5, 25000),
    MEDIANO(10, 45000),
    GRANDE(20, 70000);

    private final double metrosCuadrados;   // ← agregar "final" aquí
    private final double precioMensual;     // ← y aquí

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