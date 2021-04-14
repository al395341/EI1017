package vistas;

// Logan Ilan Kalfa

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
import excepciones.ProyectoNoSeleccionadoException;
import vistas.Almacenamiento;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Serializable {
    private ControladorPersonas controladorPersonas;
    private ControladorProyectos controladorProyectos;
    private ControladorTareas controladorTareas;
    private ControladorEtiqueta controladorEtiqueta;
    private Proyecto proyectoSeleccionado;

    public Menu(){
        controladorPersonas = new ControladorPersonas();

        controladorTareas = new ControladorTareas();
        controladorEtiqueta = new ControladorEtiqueta();
        controladorProyectos = new ControladorProyectos(controladorPersonas,controladorTareas);
        proyectoSeleccionado = null;
    }

    public void escrituraDeDatos(){
        try {
            Almacenamiento.escritura(this);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos");
        }
    }

    public void cargarMenú() {
        try {
            int opcion;
            Scanner sc = new Scanner(System.in);
            do {
                if (proyectoSeleccionado != null)
                    System.err.println("Proyecto actual " + proyectoSeleccionado.getNombre());
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
                        if (listaProyecto.size() == 0)
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
                                if (proyectoSeleccionado != null) {
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
                                    throw new ProyectoNoSeleccionadoException();
                                break;
                            case LISTAR_PERSONAS_PROYECTO:
                                if (proyectoSeleccionado != null) {
                                    System.out.println("Listado de personas");
                                    ArrayList<Persona> listaPersonas = controladorProyectos.listarPersonasProyecto(proyectoSeleccionado.getNombre());
                                    if (listaPersonas == null) {
                                        System.out.println("No hay personas asignadas al proyecto");
                                    } else {
                                        for (Persona p : listaPersonas) {
                                            System.out.println("Nombre: " + p.getNombre() + " Correo: " + p.getCorreo());
                                        }
                                    }
                                } else
                                    throw new ProyectoNoSeleccionadoException();
                                break;
                            case DAR_ALTA_TAREAS_PROYECTO:
                                if (proyectoSeleccionado != null) {
                                    System.out.println("Introduce el nombre");
                                    nombre = sc.next();
                                    System.out.println("Introduce la descripción");
                                    String desc = sc.next();
                                    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
                                    System.out.println("Introduce el nombre de la persona 0 para terminar");
                                    String nombrePersona = sc.next();
                                    System.out.println("Introduce el correo de la persona 0 para terminar");
                                    String correoPersona = sc.next();
                                    Persona persona = null;
                                    persona = new Persona(nombrePersona, correoPersona);
                                    listaPersonas.add(persona);
//                                    while (!controladorPersonas.existePersona(nombrePersona, correoPersona)) {
//                                        persona = new Persona(nombrePersona, correoPersona);
//                                        listaPersonas.add(persona);
//                                        System.out.println("Introduce el nombre de la persona 0 para terminar");
//                                        nombrePersona = sc.next();
//                                        System.out.println("Introduce el correo de la persona 0 para terminar");
//                                        correoPersona = sc.next();
//                                    }
                                    System.out.println("Selecciona un responsable de la lista anterior");
                                    System.out.println("Introduce el nombre de la persona responsable");
                                    String nombrePersonaResp = sc.next();
                                    System.out.println("Introduce el correo de la persona responsable");
                                    String correoPersonaResp = sc.next();
                                    persona = new Persona(nombrePersonaResp, correoPersonaResp);
                                    //if (listaPersonas.contains(persona)) {
                                        System.out.println("Introduce la prioridad");
                                        int prioridad = sc.nextInt();
                                        System.out.println("Introduce la fecha de inicio");
                                        String fechaInicio = sc.next();
                                        System.out.println("Introduce el resultdo esperado");
                                        String resultado = sc.next();
                                        ArrayList<Etiqueta> listaEtiquetas = new ArrayList<Etiqueta>();
                                        System.out.println("Introduce las etiquetas 0 para terminar");
                                        String etiqueta = sc.next();
                                        Etiqueta eti = new Etiqueta(etiqueta);
                                        listaEtiquetas.add(eti);
//                                        while (!controladorEtiqueta.existeEtiqueta(etiqueta)) {
//                                            Etiqueta eti = new Etiqueta(etiqueta);
//                                            listaEtiquetas.add(eti);
//                                            System.out.println("Introduce las etiquetas 0 para terminar");
//                                            etiqueta = sc.next();
//                                        }
                                        controladorProyectos.añadirTarea(proyectoSeleccionado.getNombre(), nombre, desc, listaPersonas, persona, fechaInicio, prioridad, resultado, listaEtiquetas);
                                    //}
                                } else
                                    throw new ProyectoNoSeleccionadoException();
                                break;
                            case LISTAR_TAREAS_PROYECTO:
                                if (proyectoSeleccionado != null) {
                                    controladorProyectos.listarTareasProyecto(proyectoSeleccionado.getNombre());
                                } else
                                    throw new ProyectoNoSeleccionadoException();
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
                                System.out.println("Introduce el nombre de la tarea");
                                String tarea = sc.next();
                                System.out.println(controladorProyectos.finalizarTarea(proyectoSeleccionado.getNombre(),tarea));
                                break;
                            case INTRODUCIR_PERSONA_TAREA:
                                System.out.println("Introduce el nombre de la persona que vas a añadir");
                                String nombrePersona = sc.next();
                                System.out.println("Introduce el correo de la persona que vas a añadir");
                                String correoPersona = sc.next();
                                System.out.println("Introduce la tarea que va a ser responsable");
                                tarea = sc.next();
                                Persona persona = new Persona(nombrePersona, correoPersona);
                                System.out.println(controladorProyectos.añadirPersonaTarea(proyectoSeleccionado.getNombre(),tarea,persona));
                                break;
                            case ELIMINAR_PERSONA_TAREA:
                                System.out.println("Introduce el nombre de la persona que vas a añadir");
                                nombrePersona = sc.next();
                                System.out.println("Introduce el correo de la persona que vas a añadir");
                                correoPersona = sc.next();
                                System.out.println("Introduce la tarea que va a ser responsable");
                                tarea = sc.next();
                                persona = new Persona(nombrePersona, correoPersona);
                                System.out.println(controladorProyectos.eliminarPersonaTarea(proyectoSeleccionado.getNombre(),tarea,persona));
                                break;
                            case HACER_RESPONSABLE_TAREA:
                                System.out.println("Introduce el nombre de la persona ha hacer responsable");
                                nombrePersona = sc.next();
                                System.out.println("Introduce el correo de la persona ha hacer responsable");
                                correoPersona = sc.next();
                                System.out.println("Introduce la tarea que va a ser responsable");
                                tarea = sc.next();
                                Persona p = new Persona(nombrePersona,correoPersona);
                                System.out.println(controladorProyectos.hacerResponsable(proyectoSeleccionado.getNombre(),tarea,p));
                                break;
                            case LISTAR_ETIQUETA:
                                ArrayList<Etiqueta> listaEtiquetas = controladorEtiqueta.devolverEtiquetas();
                                if (listaEtiquetas.size() == 0)
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
                                System.out.println(controladorEtiqueta.añadirEtiqueta(nombre));
                                break;
                            case ANYADIR_ETIQUETA_TAREA:
                                System.out.println("Introduce el nombre de la etiqueta que vas a añadir");
                                String nombreEtiqueta = sc.next();
                                System.out.println("Introduce la tarea");
                                tarea = sc.next();
                                Etiqueta etiqueta = new Etiqueta(nombreEtiqueta);
                                System.out.println(controladorProyectos.añadirEtiquetaTarea(proyectoSeleccionado.getNombre(),tarea,etiqueta));
                                break;
                            case ELIMINAR_ETIQUETA_TAREA:
                                System.out.println("Introduce el nombre de la etiqueta que vas a eliminar");
                                nombreEtiqueta = sc.next();
                                System.out.println("Introduce la tarea");
                                tarea = sc.next();
                                etiqueta = new Etiqueta(nombreEtiqueta);
                                System.out.println(controladorProyectos.eliminarEtiquetaTarea(proyectoSeleccionado.getNombre(),tarea,etiqueta));
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
                                System.out.println("Introduzca el correo de " + nombrePersona);
                                String correoPersona = sc.next();
                                System.out.println(controladorPersonas.anyadirPersona(nombrePersona, correoPersona));
                                break;
                            case LISTAR_PERSONAS:
                                ArrayList<Persona> listaPersonas;
                                listaPersonas = controladorPersonas.listarPersonas();
                                if (listaPersonas.size() == 0)
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
                        escrituraDeDatos();
                        System.exit(0);
                }
            } while (opcion >= 0);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("La opcion del menu es incorrecta");
        }
    }

}
