package co.edu.uniquindio.model;

import java.time.LocalDate;
import java.util.*;

public abstract class Persona {
    protected String nombre;
    protected String apellidos;
    protected String documento;
    protected LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos, String documento, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
    }
}
