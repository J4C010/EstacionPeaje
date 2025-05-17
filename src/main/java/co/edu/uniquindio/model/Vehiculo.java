package co.edu.uniquindio.model;

public abstract class Vehiculo {
    protected String placa;
    protected int numPeajesPagados = 0;
    protected double totalPagado = 0;

    public Vehiculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public int getNumPeajesPagados() {
        return numPeajesPagados;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public abstract double calcularValorPeaje();

    public abstract String getDescripcion();

    public void registrarPago(double valor) {
        numPeajesPagados++;
        totalPagado += valor;
    }
}
