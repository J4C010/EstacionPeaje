package co.edu.uniquindio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Conductor extends Persona {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Conductor(String nombre, String apellidos, String documento, LocalDate fechaNacimiento) {
        super(nombre, apellidos, documento, fechaNacimiento);
    }

    public void asignarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public double calcularTotalPagadoEnPeajes() {
        return vehiculos.stream().mapToDouble(Vehiculo::getTotalPagado).sum();
    }

    public List<Vehiculo> obtenerVehiculosPorTipo(String tipo) {
        return vehiculos.stream()
                .filter(v -> v.getClass().getSimpleName().equalsIgnoreCase(tipo))
                .toList();
    }

    public boolean tieneCamionAltoTonelaje() {
        return vehiculos.stream()
                .filter(v -> v instanceof Camion c && c.getCapacidadToneladas() > 10)
                .findFirst().isPresent();
    }
}
