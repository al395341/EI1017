package vistas;

import vistas.Menu;

import java.io.*;

public class Almacenamiento {

    public static void escritura(Menu menu) throws IOException {
        try {
            File fichero = new File("datos.dat");
            if(fichero.createNewFile()) {
                FileOutputStream salida = new FileOutputStream(fichero);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
        }catch (IOException e){
            System.out.println("Error de escritura");
        }
    }

    public static Menu lectura() {
        ObjectInputStream salida2 = null;
        Menu menu = new Menu();

        try {
            File fichero = new File("datos.dat");
            FileInputStream entrada = new FileInputStream(fichero);
            salida2 = new ObjectInputStream(entrada);
            menu = (Menu) salida2.readObject();
            System.out.println("Datos leidos");
        } catch(FileNotFoundException e){
            System.out.println("No existe el fichero");
        } catch(IOException e){
            System.out.println("Io exception");
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            System.out.println("Class exception");
        }
        return menu;
    }
}
