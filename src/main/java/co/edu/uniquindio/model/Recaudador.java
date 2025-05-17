package co.edu.uniquindio.model;

public class Recaudador extends Persona {
    private double sueldoMensual;

    public Recaudador(String nombre, String apellidos, String documento, LocalDate fechaNacimiento, double sueldoMensual) {
        super(nombre, apellidos, documento, fechaNacimiento);
        this.sueldoMensual = sueldoMensual;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }
}
