package controladores;

import clases.Etiqueta;
import clases.Persona;
import clases.Proyecto;
import clases.Tarea;
import modelos.ModeloProyectos;
import tests.T;

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

    public String añadirPersonaProyecto(String nombre, String persona, String correo) {
        if(persona.equals(" ") || persona.equals(" ")) {
            return "Los campos son obligatorios";
        }
        Persona persona1 = new Persona(persona,correo);
        ArrayList<Persona> listaPersonas = controladorPersonas.listarPersonas();
        for (Persona person: listaPersonas) {
            if(person.getNombre().equals(persona) && person.getCorreo().equals(correo))
                if(modeloProyectos.añadirPersonasProyecto(nombre,persona1)) {
                    return "Persona añadida al proyecto";
                }
        }
        return "Algo no ha funcionado bien";
    }

    public ArrayList<Persona> listarPersonasProyecto(String nombre) {
        if(nombre.equals(" "))
            return null;
        ArrayList<Persona> listaPersonas = modeloProyectos.listarPersonasProyecto(nombre);
        if (listaPersonas == null)
            return null;
        return listaPersonas;
    }

    public String añadirTarea(String proyecto, String nombre, String desc, ArrayList<Persona> listaPersonas, Persona responsable, String fechaInicio, int prioridad,String resultado ,ArrayList<Etiqueta> listaEtiquetas) {
        if(nombre.equals(" ") || desc.equals(" ") || fechaInicio.equals(" "))
            return "Los campos nombre, descripcion y fecha inicial son obligados";
        if(listaPersonas.size() == 0 || listaEtiquetas.size() == 0)
            return "Es necesario teneer personas al proyecto y etiquetas";
        if (responsable == null)
            return "Es necesaria una persona responsable";
        Tarea tarea = new Tarea(nombre,desc,listaPersonas,responsable,prioridad,fechaInicio,resultado,listaEtiquetas);
        if(modeloProyectos.añadirTareasProyecto(proyecto,tarea))
            return "Tarea añadida al proyecto";
        return "Algo ha ido mal";
    }


    public ArrayList<Tarea> listarTareasProyecto(String p) {
        return modeloProyectos.listarTareasProyecto(p);
    }


}
