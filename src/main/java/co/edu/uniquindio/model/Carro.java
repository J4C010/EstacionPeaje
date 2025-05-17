package co.edu.uniquindio.model;

public class Carro extends Vehiculo {
    private boolean electrico;
    private ServicioCarro servicio;

    public Carro(String placa, boolean electrico, ServicioCarro servicio) {
        super(placa);
        this.electrico = electrico;
        this.servicio = servicio;
    }

    @Override
    public double calcularValorPeaje() {
        double valor = 10000;
        if (electrico) valor *= 0.8;
        if (servicio == ServicioCarro.PUBLICO) valor *= 1.15;
        return valor;
    }

    @Override
    public String getDescripcion() {
        return "Carro - Placa: " + placa + ", Eléctrico: " + electrico + ", Servicio: " + servicio;
    }
}