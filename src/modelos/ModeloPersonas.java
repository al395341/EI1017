package modelos;

import clases.Persona;

import java.util.ArrayList;

public class ModeloPersonas {
    private ArrayList<Persona> listaPersonas;

    public ModeloPersonas() {
        listaPersonas = new ArrayList<Persona>();
    }

    public boolean añadirPersona(Persona p) {
        if(listaPersonas.contains(p))
            return false;
        listaPersonas.add(p);
        return true;
    }

    public boolean eliminarPersona(String nombre) {
        boolean eliminado = false;
        Persona aux = null;
        for(Persona p: listaPersonas) {
            if(p.getNombre().equals(nombre)) {
                aux = p;
                eliminado = true;
            }
        }
        if( aux != null ) {
            listaPersonas.remove(aux);
        }
        return eliminado;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

}
