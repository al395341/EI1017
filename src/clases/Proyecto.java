package clases;

// Logan Ilan Kalfa

public class Proyecto {
    private String nombre;
    private boolean finalizado;
    private boolean seleccionado;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.finalizado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

}
