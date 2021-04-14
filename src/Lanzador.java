import vistas.Almacenamiento;
import vistas.Menu;

// Logan Ilan Kalfa

public class Lanzador {
    public static void main (String[] args){
        Almacenamiento almacenamiento = new Almacenamiento();
        System.out.println("PRUBEA 1");
        Menu menu = almacenamiento.lectura();
        System.out.println("PRUBEA 2");
        menu.cargarMenú();

    }
}
