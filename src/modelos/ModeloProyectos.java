package modelos;

import clases.Persona;
import clases.Proyecto;
import clases.Tarea;
import tests.T;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ModeloProyectos {


    private HashMap<String,ArrayList<Persona>> listaPersonasProyecto;
    private HashMap<String,ArrayList<Tarea>> listaTareasProyecto;

    public ModeloProyectos() {
        listaPersonasProyecto = new HashMap<String,ArrayList<Persona>>();
        listaTareasProyecto = new HashMap<String,ArrayList<Tarea>>();
    }


    public boolean añadirProyecto(String p) {
        if(listaPersonasProyecto.containsKey(p) && listaTareasProyecto.containsKey(p))
            return false;
        else {
            listaPersonasProyecto.put(p, new ArrayList<Persona>());
            listaTareasProyecto.put(p, new ArrayList<Tarea>());
            return true;
        }
    }

    public boolean seleccionarProyecto(String p) {
        if(listaPersonasProyecto.containsKey(p) && listaTareasProyecto.containsKey(p))
            return true;
        return false;
    }

    public ArrayList<String> devolverProyecto() {
        ArrayList<String> listaProyectos = new ArrayList<String>(listaTareasProyecto.keySet());
        return listaProyectos;
    }

    public boolean añadirPersonasProyecto(String p, Persona persona) {
        if (listaPersonasProyecto.containsKey(p)) {
            ArrayList<Persona> listaPersonas = listaPersonasProyecto.get(p);
            listaPersonas.add(persona);
            listaPersonasProyecto.replace(p,listaPersonas);
            return true;
        }
        return false;
    }

    public ArrayList<Persona> listarPersonasProyecto(String p) {
        if (listaPersonasProyecto.containsKey(p)) {
            ArrayList<Persona> listaPersonas = listaPersonasProyecto.get(p);
            return listaPersonas;
        }
        return null;

    }


    public boolean añadirTareasProyecto(String p, Tarea t) {
        if (listaTareasProyecto.containsKey(p)) {
            ArrayList<Tarea> listaTareas = listaTareasProyecto.get(p);
            listaTareas.add(t);
            listaTareasProyecto.replace(p,listaTareas);
            return true;
        }
        return false;
    }

    public ArrayList<Tarea> listarTareasProyecto(String p) {
        if (listaTareasProyecto.containsKey(p)) {
            ArrayList<Tarea> listaTareas = listaTareasProyecto.get(p);
            return listaTareas;
        }
        return null;
    }


}
