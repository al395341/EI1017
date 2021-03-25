package enumeraciones;

public enum MenuPrincipal {
    // SELECCIONAR EL PROYECTO QUE VAMOS A GESTIONAR
    SELECCIONAR_PROYECTO("Selecciona un proyecto"),
    LISTAR_PROYECTO("Lista los proyectos no finalizados"),
    // SUBMENOS DE GESTION DEL PROYECTO
    GESTION_PROYECTOS("Submenú para gestionar los proyectos."),
    GESTION_TAREAS("Submenú para gestionar las tareas."),
    GESTION_PERSONAS("Submenú para gestionar las personas."),
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
