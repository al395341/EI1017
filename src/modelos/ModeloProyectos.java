package modelos;

import clases.Etiqueta;
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
        System.err.println("MODELO 1");
        if (listaTareasProyecto.containsKey(p)) {
            System.err.println("MODELO 2");
            ArrayList<Tarea> listaTareas = listaTareasProyecto.get(p);
            listaTareas.add(t);
            listaTareasProyecto.replace(p,listaTareas);
            return true;
        }
        return false;
    }

    public ArrayList<Tarea> listarTareasProyecto(String p) {
        System.err.println("MODELO 1");
        if (listaTareasProyecto.containsKey(p)) {
            System.err.println("MODELO 2");
            ArrayList<Tarea> listaTareas = listaTareasProyecto.get(p);
            return listaTareas;
        }
        return null;
    }

    public boolean hacerResponsable(String proyecto, String tarea, Persona persona) {
        if(listaTareasProyecto.containsKey(proyecto)) {
            ArrayList<Tarea> listaTareas = listaTareasProyecto.get(proyecto);
            for (Tarea t : listaTareas) {
                if(t.getNombre().equals(tarea))
                    t.setResponsable(persona);
            }
            listaTareasProyecto.replace(proyecto,listaTareas);
            return true;
        }
        return false;
    }

    public boolean finalizarTarea(String proyecto, String tarea) {
        if(listaTareasProyecto.containsKey(proyecto)) {
            ArrayList<Tarea> listaTareas = listaTareasProyecto.get(proyecto);
            for (Tarea t : listaTareas) {
                if(t.getNombre().equals(tarea))
                    t.setEstadoTarea(true);
            }
            listaTareasProyecto.replace(proyecto,listaTareas);
            return true;
        }
        return false;
    }

    public boolean añadirPersonaTarea(String proyecto, String tarea, Persona persona) {
        if(listaTareasProyecto.containsKey(proyecto)) {
            ArrayList<Tarea> listaTareas = listaTareasProyecto.get(proyecto);
            for (Tarea t : listaTareas) {
                if(t.getNombre().equals(tarea))
                    t.getListaParticipantes().add(persona);
            }
            listaTareasProyecto.replace(proyecto,listaTareas);
            return true;
        }
        return false;
    }

    public boolean eliminarPersonaTarea(String proyecto, String tarea, Persona persona) {
        if(listaTareasProyecto.containsKey(proyecto)) {
            ArrayList<Tarea> listaTareas = listaTareasProyecto.get(proyecto);
            for (Tarea t : listaTareas) {
                if(t.getNombre().equals(tarea))
                    t.getListaParticipantes().remove(persona);
            }
            listaTareasProyecto.replace(proyecto,listaTareas);
            return true;
        }
        return false;
    }

    public boolean añadirEtiquetaTarea(String proyecto, String tarea, Etiqueta etiqueta) {
        if(listaTareasProyecto.containsKey(proyecto)) {
            ArrayList<Tarea> listaTareas = listaTareasProyecto.get(proyecto);
            for (Tarea t : listaTareas) {
                if(t.getNombre().equals(tarea))
                    t.getEtiquetas().add(etiqueta);
            }
            listaTareasProyecto.replace(proyecto,listaTareas);
            return true;
        }
        return false;
    }

    public boolean eliminarEtiquetaTarea(String proyecto, String tarea, Etiqueta etiqueta) {
        if(listaTareasProyecto.containsKey(proyecto)) {
            ArrayList<Tarea> listaTareas = listaTareasProyecto.get(proyecto);
            for (Tarea t : listaTareas) {
                if(t.getNombre().equals(tarea))
                    t.getEtiquetas().remove(etiqueta);
            }
            listaTareasProyecto.replace(proyecto,listaTareas);
            return true;
        }
        return false;
    }
}
