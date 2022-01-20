package request_one;


import request_one.entity.Almacen;
import request_one.entity.Coche;
import java.util.Scanner;

public class Server {
    // Ruta fichero
    public static final String NOMBRE_FICHERO = "coches.dat";

    public static void main(String[] args) {
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println("        ALMACEN TARTANACAR      ");
        System.out.println("-----------------------------------");

        // Bloque try, abre el escaner y lo cierra al terminar el bloque.
        try (Scanner sc = new Scanner(System.in)){

            System.out.println("BUSCANDO FICHERO DE DATOS");

            Almacen alm = new Almacen(NOMBRE_FICHERO);
            alm.initFile();
            System.out.println("ARCHIVO ENCONTRADO, ACCESO PERMITIDO");


            //--------------------- MENU --------------------------

            // boolean para controlar la salida del do while.
            boolean flag = true;

            do {
                // Solicita al usuario que elija una opcion por consola.
                System.out.println(
                        "-----------------------------------\n"
                        + "Tiene que elegir una de estas opciones:"
                        + "\n 1-. Anadir nuevo coche"
                        + "\n 2-. Borrar coche por id"
                        + "\n 3-. Consulta coche por id"
                        + "\n 4-. Listado de coches"
                        + "\n 5-. Salir de la aplicacion"
                        + "\n-----------------------------------");

                // Lee la respuesta del usuario por consola.
                String answer = sc.nextLine();

                // Variable donde almacenaremos la respuesta del servidor.
                String respuesta = null;

                // Bucle que solicita un numero hasta que el valor introducido sea 1, 2 o 3.
                while (!answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4")
                        && !answer.equals("5")) {

                    System.out.println("Tiene que escoger una de las 5 opciones");

                    // Lee la respuesta del usuario por consola.
                    answer = sc.nextLine();
                }

                //Respuesta del programa segun la eleccion del usuario.
                switch (answer) {

                    case "1":

                        // Informa de la eleccion del cliente
                        System.out.println("Ha seleccionado dar de alta un vehiculo");

                        // Creamos un nuevo objeto de la clase Coche sin argumentos
                        Coche c1 = new Coche();

                        // Solicita por consola informacion del vehiculo.
                        System.out.println("Introduce la matricula del vehiculo");
                        c1.setMatricula(sc.nextLine());
                        System.out.println("Introduce la marca del vehiculo");
                        c1.setMarca(sc.nextLine());
                        System.out.println("Introduce el modelo del vehiculo");
                        c1.setModelo(sc.nextLine());
                        System.out.println("Introduce el color del vehiculo");
                        c1.setColor(sc.nextLine());

                        alm.addItem(c1);
                        // Salida del Switch.
                        break;

                    case "2":
                        // Solicita por consola el ID del coche
                        System.out.println("Introduce el ID del vehiculo que deseas borrar: ");

                        // Lee el ID introducido por consola.
                        respuesta = alm.delByID(Integer.parseInt(sc.nextLine()));

                        // Salida del Switch.
                        break;

                    case "3":
                        // Devuelve la lista de coches.
                        respuesta = alm.getStock().toString();

                        // Salida del Switch.
                        break;

                    case "4":
                        // Solicita por consola el ID del coche
                        System.out.println("Introduce el ID del vehiculo que deseas encontrar: ");

                        // Lee el ID introducido por consola.
                        respuesta = alm.getById(Integer.parseInt(sc.nextLine())).toString();

                        // Salida del Switch.
                        break;

                    case "5":
                        // Cambia el boolean para salir del do while.
                        flag = false;
                        respuesta = alm.updateFile();

                        // Salida del Switch.
                        break;
                }

                // Imprime la respuesta por consola.
                System.out.println(respuesta);

                // Fin del do while, comprueba si el boolean es true.
            }while(flag);

            // Captura las posibles excepciones.
        } catch (Exception e) {
            System.err.println("CLIENTE: Error -> " + e);
            e.printStackTrace();
        }


    }

}
