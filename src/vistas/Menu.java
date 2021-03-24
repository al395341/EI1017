package vistas;

import controladores.ControladorPersonas;
import controladores.ControladorProyectos;
import controladores.ControladorTareas;
import enumeraciones.MenuPrincipal;

import java.util.Scanner;

public class Menu {
    private ControladorPersonas controladorPersonas;
    private ControladorProyectos controladorProyectos;
    private ControladorTareas controladorTareas;

    public Menu(){
        controladorPersonas = new ControladorPersonas();
        controladorProyectos = new ControladorProyectos();
        controladorTareas = new ControladorTareas();

    }
    public void cargarMenú(){
        int opcion;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println(MenuPrincipal.getMenu());
            System.out.println("Elige una opción");
            opcion = sc.nextByte();
            MenuPrincipal menuPrincipal = MenuPrincipal.getOpcion(opcion);
            switch (menuPrincipal) {
                case INICIAR_PROYECTO:
                    System.out.println("Indica el nombre del proyecto:");
                    controladorProyectos.iniciarProyecto(sc.next());
                    break;
                case DAR_ALTA_PERSONAS_PROYECTO:
                    break;
                case DAR_ALTA_TAREA:
                    break;
                case INTRODUCIR_O_ELIMINAR_PERSONA:
                    break;
                case LISTAR_TAREAS_PROYECTO:
                    break;
                case FINALIZAR_TAREA:
                    break;
                case LISTAR_PERSONAS_PROYECTO:
                    break;
                case SALIR:
                    break;

            }

        }while (opcion >= 0);


    }

}
