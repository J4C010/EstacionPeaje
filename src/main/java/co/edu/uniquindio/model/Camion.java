package co.edu.uniquindio.model;

public class Camion extends Vehiculo {
    private int numEjes;
    private double capacidadToneladas;

    public Camion(String placa, int numEjes, double capacidadToneladas) {
        super(placa);
        this.numEjes = numEjes;
        this.capacidadToneladas = capacidadToneladas;
    }

    public double getCapacidadToneladas() {
        return capacidadToneladas;
    }

    @Override
    public double calcularValorPeaje() {
        double base = 7000 * numEjes;
        if (capacidadToneladas > 10) base *= 1.10;
        return base;
    }

    @Override
    public String getDescripcion() {
        return "Camion - Placa: " + placa + ", Ejes: " + numEjes + ", Capacidad: " + capacidadToneladas + "T";
    }
}
