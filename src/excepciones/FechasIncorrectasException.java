package excepciones;

public class FechasIncorrectasException extends RuntimeException{
    public FechasIncorrectasException() {
        super("La fecha de finalizacion no puede ser anterior a la de inicio");
    }
}
