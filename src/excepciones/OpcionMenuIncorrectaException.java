package excepciones;

public class OpcionMenuIncorrectaException extends RuntimeException{
    public OpcionMenuIncorrectaException() {
        super("La opcion del menu es incorrecta");
    }
}
