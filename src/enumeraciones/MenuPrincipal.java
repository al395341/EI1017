package enumeraciones;

public enum MenuPrincipal {
    INICIAR_PROYECTO("Iniciar un nuevo proyecto y darle nombre."),
    DAR_ALTA_PERSONAS_PROYECTO("Dar de alta a las personas que trabajan en el proyecto."),
    DAR_ALTA_TAREA("Dar de alta las tareas con sus datos."),
    FINALIZAR_TAREA("Marcar una tarea como finalizada."),
    INTRODUCIR_O_ELIMINAR_PERSONA("Introducir o eliminar una persona de una tarea."),
    LISTAR_PERSONAS_PROYECTO("Listar las personas asignadas a un proyecto."),
    LISTAR_TAREAS_PROYECTO("Listar las tareas de un proyecto."),
    SALIR("Cerrar programa.");


    private String descripcion;
    MenuPrincipal(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public static MenuPrincipal getOpcion(int posicion) {
        return values()[posicion];
    }
    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (MenuPrincipal opcion : MenuPrincipal.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
