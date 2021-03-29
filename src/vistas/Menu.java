package vistas;

import clases.Etiqueta;
import clases.Persona;
import clases.Proyecto;
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
    private Proyecto proyectoSeleccionado;

    public Menu(){
        controladorPersonas = new ControladorPersonas();
        controladorProyectos = new ControladorProyectos(controladorPersonas);
        controladorTareas = new ControladorTareas();
        contraladorEtiqueta = new ControladorEtiqueta();
        proyectoSeleccionado = null;
    }
    public void cargarMenú(){

        int opcion;
        Scanner sc = new Scanner(System.in);
        do{
            if(proyectoSeleccionado != null)
                System.err.println("Proyecto actual "+proyectoSeleccionado.getNombre());
            System.out.println(MenuPrincipal.getMenu());
            System.out.println("Elige una opción");
            opcion = sc.nextByte();
            MenuPrincipal menuPrincipal = MenuPrincipal.getOpcion(opcion);
            switch (menuPrincipal) {
                case SELECCIONAR_PROYECTO:
                    System.out.println("Introduce el nombre del proyecto a seleccionar");
                    String nombre = sc.next();
                    if (controladorProyectos.seleccionarProyecto(nombre))
                        proyectoSeleccionado = new Proyecto(nombre);
                    else
                        System.out.println("El proyecto no existe");
                    break;
                case LISTAR_PROYECTO:
                    ArrayList<String> listaProyecto = controladorProyectos.devolverProyectos();
                    if(listaProyecto.size() == 0)
                        System.out.println("Sin proyectos");
                    else {
                        System.out.println("Listado de proyectos");
                        for (String p : listaProyecto) {
                            System.out.println(p);
                        }
                    }
                    break;
                case GESTION_PROYECTOS:
                    System.out.println(MenuProyectos.getMenu());
                    System.out.println("Elige una opción");
                    opcion = sc.nextByte();
                    MenuProyectos menuProyectos = MenuProyectos.getOpcion(opcion);
                    switch (menuProyectos) {
                        case CREAR_PROYECTO:
                            System.out.println("Introduce el nombre del proyecto a iniciar");
                            controladorProyectos.iniciarProyecto(sc.next());
                            break;
                        case DAR_ALTA_PERSONAS_PROYECTO:
                            if(proyectoSeleccionado != null) {
                                System.out.println("Introduce el nombre de las personas a dar de alta 0 para terminar");
                                System.out.println("Introduce el nombre");
                                String nombrePersona = sc.next();
                                while (!nombrePersona.equals("0")) {
                                    System.out.println("Introduce el correo");
                                    String correoPersona = sc.next();
                                    controladorProyectos.añadirPersonaProyecto(proyectoSeleccionado.getNombre(), nombrePersona, correoPersona);
                                    System.out.println("Introduce el nombre 0 para terminar");
                                    nombrePersona = sc.next();
                                }
                                System.out.println("Personas introducidas");
                            } else
                                System.err.println("Seleccione un proyecto primero");
                            break;
                        case DAR_ALTA_TAREAS_PROYECTO:
                            System.out.println("Dar de alta tareas");
                            break;
                        case LISTAR_TAREAS_PROYECTO:
                            System.out.println("Listado de tareas");
                            break;
                        case LISTAR_PERSONAS_PROYECTO:
                            if (proyectoSeleccionado != null) {
                                System.out.println("Listado de personas");
                                ArrayList<Persona> listaPersonas = controladorProyectos.listarPersonasProyecto(proyectoSeleccionado.getNombre());
                                if (listaPersonas == null) {
                                    System.out.println("No hay personas asignadas al proyecto");
                                }
                                else {
                                    for (Persona p : listaPersonas) {
                                        System.out.println("Nombre: " + p.getNombre() + " Correo: " + p.getCorreo());
                                    }
                                }
                            } else
                                System.err.println("Seleccione un proyecto primero");
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
                            ArrayList<Etiqueta> listaEtiquetas = contraladorEtiqueta.devolverEtiquetas();
                            if(listaEtiquetas.size() == 0)
                                System.out.println("Sin etiquetas");
                            else {
                                for (Etiqueta etiqueta : listaEtiquetas) {
                                    System.out.println(etiqueta.getNombre());
                                }
                            }
                            break;
                        case DAR_ALTA_ETIQUETA:
                            System.out.println("Introduce la etiqueta");
                            nombre = sc.next();
                            System.out.println(contraladorEtiqueta.añadirEtiqueta(nombre));
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
                            System.out.println("Introduzca el nombre de la persona");
                            String nombrePersona = sc.next();
                            System.out.println("Introduzca el correo de "+nombrePersona);
                            String correoPersona = sc.next();
                            System.out.println(controladorPersonas.añadirPersona(nombrePersona,correoPersona));
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
                            System.out.println("Introduce el nombre de la persona a eliminar");
                            nombrePersona = sc.next();
                            System.out.println(controladorPersonas.darBajaPersona(nombrePersona));
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
