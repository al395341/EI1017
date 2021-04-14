package excepciones;

public class PersonaEnTareaException extends RuntimeException{
    public PersonaEnTareaException() {
        super("La persona ya está en la tarea");
    }
}
