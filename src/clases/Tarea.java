package clases;

// Logan Ilan Kalfa

import java.util.ArrayList;

public class Tarea {

    private String nombre;
    private String descripcion;
    private ArrayList<Persona> listaParticipantes;
    private Persona responsable;
    private int prioridad;
    private String fechaCreacion;
    private String fechaFinalizacion;
    private boolean estadoTarea;
    private String resultado;
    private ArrayList<Etiqueta> etiquetas;

    public Tarea(String nombre, String descripcion, ArrayList<Persona> listaParticipantes, Persona responsable, int prioridad, String fechaCreacion, String resultado, ArrayList<Etiqueta> etiquetas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaParticipantes = listaParticipantes;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.fechaCreacion = fechaCreacion;
        this.fechaFinalizacion = "";
        this.estadoTarea = false;
        this.resultado = resultado;
        this.etiquetas = etiquetas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Persona> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(ArrayList<Persona> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public boolean isEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(boolean estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
}
