package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

public class EstacionPeaje {
    private String nombre;
    private String departamento;
    private double totalRecaudado;
    private List<RegistroPaso> vehiculosRecibidos = new ArrayList<>();

    public EstacionPeaje(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public void calcularYRegistrarPeaje(Vehiculo v) {
        double valor = v.calcularValorPeaje();
        v.registrarPago(valor);
        totalRecaudado += valor;
        vehiculosRecibidos.add(new RegistroPaso(v, valor));
    }

    public void imprimirListadoVehiculos() {
        for (RegistroPaso rp : vehiculosRecibidos) {
            System.out.println(rp.vehiculo().getDescripcion() + " - Peaje: $" + rp.valorPagado());
        }
        System.out.println("TOTAL RECAUDADO: $" + totalRecaudado);
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }
}
