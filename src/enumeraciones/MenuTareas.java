package enumeraciones;

// Logan Ilan Kalfa

public enum MenuTareas {
    // FINALIZAMOS UNA TAREA
    FINALIZAR_TAREA("Marcar una tarea como finalizada."),
    // DE LAS PERSONAS CREADAS AÑADIMOS, ELIMINAMOS O PROMOCIONAMOS A RESPONSABLE DE LAS TAREAS.
    INTRODUCIR_PERSONA_TAREA("Introducir una persona en una tarea."),
    ELIMINAR_PERSONA_TAREA("Eliminar una persona de una tarea."),
    HACER_RESPONSABLE_TAREA("Introducir o eliminar una persona de una tarea."),
    // CREAMOS LAS ETIQUETAS PARA RESTRINGIR EL USO DE SINONIMOS ENTRE TAREAS E IR TODOS AL UNISONO
    DAR_ALTA_ETIQUETA("Crea un etiqueta para las tareas."),
    LISTAR_ETIQUETA("Listar etiquetas."),
    // AÑADIMOS DE LAS ETIQUETAS CREADAS LA QUE SELECCIONEMOS A LA TAREA
    ANYADIR_ETIQUETA_TAREA("Añadir una etiqueta a una tarea"),
    ELIMINAR_ETIQUETA_TAREA("Eliminar una etiqueta a una tarea"),
    SALIR("Volver atras.");


    private String descripcion;
    MenuTareas(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public static MenuTareas getOpcion(int posicion) {
        return values()[posicion];
    }
    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (MenuTareas opcion : MenuTareas.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
