package clases;

// Logan Ilan Kalfa

public class Documentacion extends Resultado {

    private String formatoDocumento;
    private int numPaginas;
    private int espacioDisco;

    public Documentacion(String identificador, int numeroHoras, boolean comercial, String formatoDocumento, int numPaginas, int espacioDisco) {
        super(identificador,numeroHoras,comercial);
        this.formatoDocumento = formatoDocumento;
        this.numPaginas = numPaginas;
        this.espacioDisco = espacioDisco;
    }

    public String getFormatoDocumento() {
        return formatoDocumento;
    }

    public void setFormatoDocumento(String formatoDocumento) {
        this.formatoDocumento = formatoDocumento;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getEspacioDisco() {
        return espacioDisco;
    }

    public void setEspacioDisco(int espacioDisco) {
        this.espacioDisco = espacioDisco;
    }
}
