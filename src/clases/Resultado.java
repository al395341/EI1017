package clases;

// Logan Ilan Kalfa

public class Resultado {

    private String identificador;
    private int numeroHoras;
    private boolean comercial;

    public Resultado(String identificador, int numeroHoras, boolean comercial) {
        this.identificador = identificador;
        this.numeroHoras = numeroHoras;
        this.comercial = comercial;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public boolean isComercial() {
        return comercial;
    }

    public void setComercial(boolean comercial) {
        this.comercial = comercial;
    }
}
