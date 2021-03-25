package vistas;

import clases.Persona;
import controladores.ControladorEtiqueta;
import controladores.ControladorPersonas;
import controladores.ControladorProyectos;
import controladores.ControladorTareas;
import enumeraciones.MenuPersonas;
import enumeraciones.MenuPrincipal;
import enumeraciones.MenuProyectos;
import enumeraciones.MenuTareas;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ControladorPersonas controladorPersonas;
    private ControladorProyectos controladorProyectos;
    private ControladorTareas controladorTareas;
    private ControladorEtiqueta contraladorEtiqueta;

    public Menu(){
        controladorPersonas = new ControladorPersonas();
        controladorProyectos = new ControladorProyectos();
        controladorTareas = new ControladorTareas();
        contraladorEtiqueta = new ControladorEtiqueta();
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
                case SELECCIONAR_PROYECTO:
                    System.out.println("Seleccionar un proyecto");
                    break;
                case LISTAR_PROYECTO:
                    System.out.println("Listado de proyectos sin finalizar");
                    break;
                case GESTION_PROYECTOS:
                    System.out.println(MenuProyectos.getMenu());
                    System.out.println("Elige una opción");
                    opcion = sc.nextByte();
                    MenuProyectos menuProyectos = MenuProyectos.getOpcion(opcion);
                    switch (menuProyectos) {
                        case CREAR_PROYECTO:
                            System.out.println("Crear un proyecto");
                            break;
                        case DAR_ALTA_PERSONAS_PROYECTO:
                            System.out.println("Dar de alta personas");
                            break;
                        case DAR_ALTA_TAREAS_PROYECTO:
                            System.out.println("Dar de alta tareas");
                            break;
                        case LISTAR_TAREAS_PROYECTO:
                            System.out.println("Listado de tareas");
                            break;
                        case LISTAR_PERSONAS_PROYECTO:
                            System.out.println("Listado de personas");
                            break;
                        case SALIR:
                            break;
                    }
                    break;
                case GESTION_TAREAS:
                    System.out.println(MenuTareas.getMenu());
                    System.out.println("Elige una opción");
                    opcion = sc.nextByte();
                    MenuTareas menuTareas = MenuTareas.getOpcion(opcion);
                    switch (menuTareas) {
                        case FINALIZAR_TAREA:
                            System.out.println("Finalizar una tarea");
                            break;
                        case INTRODUCIR_PERSONA_TAREA:
                            System.out.println("Introducir persona en una tarea");
                            break;
                        case ELIMINAR_PERSONA_TAREA:
                            System.out.println("Eliminar persona en una tarea");
                            break;
                        case HACER_RESPONSABLE_TAREA:
                            System.out.println("Responsabilizar a una persona en una tarea");
                            break;
                        case LISTAR_ETIQUETA:
                            System.out.println("Listar etiquetas creadas");
                            break;
                        case DAR_ALTA_ETIQUETA:
                            System.out.println("Crear etiquetas");
                            break;
                        case ELIMINAR_ETIQUETA:
                            System.out.println("Eliminar etiquetas");
                            break;
                        case ANYADIR_ETIQUETA_TAREA:
                            System.out.println("Añadir etiqueta a una tarea");
                            break;
                        case ELIMINAR_ETIQUETA_TAREA:
                            System.out.println("Eliminar etiqueta de una tarea");
                            break;
                        case SALIR:
                            break;
                    }
                    break;
                case GESTION_PERSONAS:
                    System.out.println(MenuPersonas.getMenu());
                    System.out.println("Elige una opción");
                    opcion = sc.nextByte();
                    MenuPersonas menuPersonas = MenuPersonas.getOpcion(opcion);
                    switch (menuPersonas) {
                        case DAR_ALTA_PERSONA:
                            System.out.println("Crear una persona");
                            System.out.println(controladorPersonas.añadirPersona("Albert","al341911@uji.es"));
                            break;
                        case LISTAR_PERSONAS:
                            ArrayList<Persona> listaPersonas;
                            listaPersonas = controladorPersonas.listarPersonas();
                            if(listaPersonas.size() == 0)
                                System.out.println("No hay personas");
                            else {
                                for (Persona p : listaPersonas) {
                                    System.out.println("Nombre: " + p.getNombre() + " Correo: " + p.getCorreo());
                                }
                            }
                            break;
                        case ELIMINAR_PERSONA:
                            System.out.println("Eliminar una persona");
                            System.out.println(controladorPersonas.darBajaPersona("Albert"));
                            break;
                        case SALIR:
                            break;
                    }
                    break;
                case SALIR:
                    System.out.println("Salimos del programa gracias!");
                    System.exit(0);
            }

        }while (opcion >= 0);


    }

}
