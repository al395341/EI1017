package enumeraciones;

public enum MenuProyectos {
    // CREAR UN PROYECTO NUEVO
    CREAR_PROYECTO("Crea un proyecto nuevo"),
    // DAMOS DE ALTA TANTO TAREAS COMO PERSONAS AL PROYECTO
    DAR_ALTA_TAREAS_PROYECTO("Dar de alta las tareas con sus datos."),
    DAR_ALTA_PERSONAS_PROYECTO("Dar de alta las personas del proyecto."),
    LISTAR_PERSONAS_PROYECTO("Listar participantes del proyecto."),
    LISTAR_TAREAS_PROYECTO("Listar las tareas del proyecto."),
    SALIR("Volver atras.");


    private String descripcion;
    MenuProyectos(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public static MenuProyectos getOpcion(int posicion) {
        return values()[posicion];
    }
    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (MenuProyectos opcion : MenuProyectos.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
