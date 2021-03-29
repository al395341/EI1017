package controladores;


import clases.Etiqueta;
import modelos.ModeloEtiquetas;

import java.util.ArrayList;

public class ControladorEtiqueta {

    private ModeloEtiquetas modeloEtiquetas;

    public ControladorEtiqueta() {
        modeloEtiquetas = new ModeloEtiquetas();
    }

    public String añadirEtiqueta(String nombre) {
        if(nombre.equals(" "))
            return "La etiqueta necesita un nombre";
        Etiqueta etiqueta = new Etiqueta(nombre);
        modeloEtiquetas.añadirEtiqueta(etiqueta);
        return "Etiqueta insertada";
    }

    public ArrayList<Etiqueta> devolverEtiquetas() {
        return modeloEtiquetas.listarEtiquetas();
    }

    public boolean existeEtiqueta(String etiqueta) {
        ArrayList<Etiqueta> listaEtiquetas = modeloEtiquetas.listarEtiquetas();
        Etiqueta e = new Etiqueta(etiqueta);
        return listaEtiquetas.contains(e);
    }

}
