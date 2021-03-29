package excepciones;

public class ProyectoNoSeleccionadoException extends RuntimeException{
    public ProyectoNoSeleccionadoException() {
        super("No has seleccionado un proyecto. Selecciona uno para poder continuar");
    }
}
