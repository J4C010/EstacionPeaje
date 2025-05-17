package co.edu.uniquindio.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

public class EstacionPeajeTest {

    private Conductor conductor;
    private EstacionPeaje peaje;
    private Carro carro;
    private Moto moto;
    private Camion camion;

    @BeforeEach
    public void setup() {
        conductor = new Conductor("Juan", "Pérez", "12345", LocalDate.of(1985, 6, 15));
        peaje = new EstacionPeaje("Peaje Norte", "Cundinamarca");
        carro = new Carro("ABC123", true, ServicioCarro.PUBLICO);
        moto = new Moto("XYZ987", 250);
        camion = new Camion("TRK456", 4, 12.0);
    }

    @Test
    public void testAsignarVehiculoAConductor() {
        conductor.asignarVehiculo(carro);
        assertEquals(1, conductor.getVehiculos().size());
    }

    @Test
    public void testCalculoPeajeCarroElectricoPublico() {
        double valor = carro.calcularValorPeaje();
        assertEquals(9200.0, valor, 0.01); // 10000 * 0.8 * 1.15
    }

    @Test
    public void testCalculoPeajeMotoAltaCilindraje() {
        double valor = moto.calcularValorPeaje();
        assertEquals(7000.0, valor, 0.01);
    }

    @Test
    public void testCalculoPeajeCamionAltoTonelaje() {
        double valor = camion.calcularValorPeaje();
        assertEquals(30800.0, valor, 0.01); // 7000 * 4 * 1.10
    }

    @Test
    public void testRegistrarPeajeYRecaudoTotal() {
        peaje.calcularYRegistrarPeaje(carro);
        peaje.calcularYRegistrarPeaje(moto);
        assertEquals(16200.0, peaje.getTotalRecaudado(), 0.01);
    }

    @Test
    public void testTotalPagadoPorConductor() {
        conductor.asignarVehiculo(carro);
        conductor.asignarVehiculo(moto);
        carro.registrarPago(carro.calcularValorPeaje());
        moto.registrarPago(moto.calcularValorPeaje());
        assertEquals(16200.0, conductor.calcularTotalPagadoEnPeajes(), 0.01);
    }

    @Test
    public void testObtenerVehiculosPorTipo() {
        conductor.asignarVehiculo(carro);
        conductor.asignarVehiculo(moto);
        List<Vehiculo> lista = conductor.obtenerVehiculosPorTipo("Carro");
        assertEquals(1, lista.size());
        assertTrue(lista.get(0) instanceof Carro);
    }

    @Test
    public void testBuscarRecaudadorPorNombreCompleto() {
        Recaudador rec = new Recaudador("Ana", "Gomez", "654321", LocalDate.of(1990, 4, 20), 2000000);
        boolean coincide = ("Ana Gomez".trim().equalsIgnoreCase((rec.nombre + " " + rec.apellidos).trim()));
        assertTrue(coincide);
    }

    @Test
    public void testConductorConCamionAltoTonelaje() {
        conductor.asignarVehiculo(camion);
        assertTrue(conductor.tieneCamionAltoTonelaje());
    }
}