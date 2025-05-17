package co.edu.uniquindio.model;

public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(String placa, int cilindraje) {
        super(placa);
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularValorPeaje() {
        return 5000 + (cilindraje > 200 ? 2000 : 0);
    }

    @Override
    public String getDescripcion() {
        return "Moto - Placa: " + placa + ", Cilindraje: " + cilindraje;
    }
}