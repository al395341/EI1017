package clases;

import tests.T;

import java.util.ArrayList;

// Logan Ilan Kalfa

public class Persona {

    private String nombre;
    private String correo;
    private ArrayList<Tarea> listaTareasResponsable;

    public Persona(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        listaTareasResponsable = new ArrayList<Tarea>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
