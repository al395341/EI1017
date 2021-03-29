package clases;

public class Programa extends Resultado{

    private String lenguaje;
    private int numLineas;
    private int numModulos;

    public Programa(String identificador, int numeroHoras, boolean comercial, String lenguaje, int numLineas, int numModulos) {
        super(identificador,numeroHoras,comercial);
        this.lenguaje = lenguaje;
        this.numLineas = numLineas;
        this.numModulos = numModulos;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public int getNumLineas() {
        return numLineas;
    }

    public void setNumLineas(int numLineas) {
        this.numLineas = numLineas;
    }

    public int getNumModulos() {
        return numModulos;
    }

    public void setNumModulos(int numModulos) {
        this.numModulos = numModulos;
    }
}
