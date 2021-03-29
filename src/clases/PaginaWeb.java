package clases;

public class PaginaWeb extends Resultado{

    private boolean dinamica;
    private String lenguaje;
    private String backend;

    public PaginaWeb(String identificador, int numeroHoras, boolean comercial, boolean dinamica, String lenguaje, String backend) {
        super(identificador,numeroHoras,comercial);
        this.dinamica = dinamica;
        this.lenguaje = lenguaje;
        this.backend = backend;
    }

    public boolean isDinamica() {
        return dinamica;
    }

    public void setDinamica(boolean dinamica) {
        this.dinamica = dinamica;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }
}
