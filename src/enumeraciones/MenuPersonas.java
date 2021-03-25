package enumeraciones;

public enum MenuPersonas {
    // GESTION DE LOS TRABAJADORES DE LOS PROYECTOS Y TAREAS
    DAR_ALTA_PERSONA("Dar de alta a una persona."),
    ELIMINAR_PERSONA("Eliminar una persona."),
    LISTAR_PERSONAS("Listar las personas."),
    SALIR("Volver atras.");


    private String descripcion;
    MenuPersonas(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public static MenuPersonas getOpcion(int posicion) {
        return values()[posicion];
    }
    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (MenuPersonas opcion : MenuPersonas.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
