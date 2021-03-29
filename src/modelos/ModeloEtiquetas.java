package modelos;

// Logan Ilan Kalfa

import clases.Etiqueta;

import java.util.ArrayList;

public class ModeloEtiquetas {

    private ArrayList<Etiqueta> listaEtiquetas;

    public ModeloEtiquetas() {
        listaEtiquetas = new ArrayList<Etiqueta>();
    }


    public boolean añadirEtiqueta(Etiqueta e) {
        if(listaEtiquetas.contains(e))
            return false;
        else {
            listaEtiquetas.add(e);
            return true;
        }
    }

    public ArrayList<Etiqueta> listarEtiquetas() {
        return listaEtiquetas;
    }


}
