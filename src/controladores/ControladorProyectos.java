package controladores;

import clases.Persona;
import clases.Proyecto;
import modelos.ModeloProyectos;

import java.util.ArrayList;

public class ControladorProyectos {

    private ModeloProyectos modeloProyectos;
    private ControladorPersonas controladorPersonas;

    public ControladorProyectos(ControladorPersonas controladorPersonas) {
        modeloProyectos = new ModeloProyectos();
        this.controladorPersonas = controladorPersonas;
    }

    public String iniciarProyecto(String nombre) {
        if(nombre.equals(" "))
            return "El nombre es obligatorio";
        modeloProyectos.añadirProyecto(nombre);
        return "Proyecto añadido con exito";
    }

    public ArrayList<String> devolverProyectos() {
        return modeloProyectos.devolverProyecto();
    }

    public boolean seleccionarProyecto(String nombre) {
        Proyecto p = new Proyecto(nombre);
        if(nombre.equals(" ") || !modeloProyectos.seleccionarProyecto(nombre))
            return false;
        return true;
    }

    public boolean añadirPersonaProyecto(String nombre, String persona, String correo) {
        if(persona.equals(" ") || persona.equals(" ")) {
            return false;
        }
        Persona persona1 = new Persona(persona,correo);
        ArrayList<Persona> listaPersonas = controladorPersonas.listarPersonas();
        for (Persona person: listaPersonas) {
            if(person.getNombre().equals(persona) && person.getCorreo().equals(correo))
                if(modeloProyectos.añadirPersonasProyecto(nombre,persona1)) {
                    return true;
                }
        }
        return false;
    }

    public ArrayList<Persona> listarPersonasProyecto(String nombre) {
        if(nombre.equals(" "))
            return null;
        ArrayList<Persona> listaPersonas = modeloProyectos.listarPersonasProyecto(nombre);
        if (listaPersonas == null)
            return null;
        return listaPersonas;
    }

    public boolean añadirTareasProyecto(Proyecto p) {
        return false;
    }

    public String[] listarTareasProyecto(Proyecto p) {
        return null;
    }


}
