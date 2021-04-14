package controladores;

// Logan Ilan Kalfa

import clases.Persona;
import modelos.ModeloPersonas;

import java.util.ArrayList;

public class ControladorPersonas {
    private ModeloPersonas modeloPersonas;
    public ControladorPersonas() {
        modeloPersonas = new ModeloPersonas();
    }
    /*
    *
    * Metodo que recibe un nombre y un correo conprueba la validez de los datos
    * Devuelve true en el caso de ser validos dichos datos y false en el caso contrario
    *
    * */
    public  String anyadirPersona(String nombre, String correo) {
        if(nombre.equals(" ") || correo.equals(" ")) {
            return "Los campos no pueden estar vacios";
        }
        Persona p = new Persona(nombre,correo);
        if(modeloPersonas.añadirPersona(p)) {
            return "Persona añadida correctamente";
        } else {
            return "La persona no se ha añadido debido a un error";
        }
    }
    /*
     * Metodo que recibe una persona conprueba si existe dicha persona
     * Devuelve true en el caso de ser validos dichos datos y false en el caso contrario
     *
     * */
    public String darBajaPersona(String persona){
        if(persona.equals(" ")) {
            return "Los campos son obligatorios";
        }
        if(modeloPersonas.eliminarPersona(persona)) {
            return "Persona eliminada con exito";
        }
        return "La persona no existe";
    }

    /*
    * Metodo que devuelve la lista de personas.
    *
    * */
    public ArrayList<Persona> listarPersonas() {
        return modeloPersonas.getListaPersonas();
    }

    public boolean existePersona(String nombre, String correo) {
        if(nombre.equals(" ") || correo.equals(" "))
            return false;
        ArrayList<Persona> listaPersonas = listarPersonas();
        for (Persona p : listaPersonas) {
            if(p.getNombre().equals(nombre) && p.getCorreo().equals(correo))
                return true;
        }
        return true;
    }

}
