package main.java.request_one.entity;

import java.io.*;
import java.util.ArrayList;

public class Almacen {

    private static String NOMBRE_FICHERO;

    // Almacena los coches en una lista.
    private ArrayList<Coche> stock;

    // Constructor
    public Almacen (String NOMBRE_FICHERO) {
        super();
        this.NOMBRE_FICHERO = NOMBRE_FICHERO;
        // Crea una lista al inicializarse
        this.setStock(new ArrayList());
    }

    // Getters y setters
    public static String getNombreFichero() {
        return NOMBRE_FICHERO;
    }

    public ArrayList<Coche> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Coche> stock) {
        this.stock = stock;
    }
    // Metodos sobreescritos


    // Metodos
    public void addItem(Coche coche) {
        stock.add(coche);
    }

    public void getForID() {
    }

    public void getAll() {
    }

    public void delForID() {
    }


    public void initFile() {
        Gson gson = new Gson();
        try (FileReader fr = new FileReader(getNombreFichero());
             BufferedReader br = new BufferedReader(fr);) {

            String json = gson.toJson();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String updateFile() {

        Gson gson = new Gson();
        String json = gson.toJson(getStock());

        try(FileWriter fw = new FileWriter(getNombreFichero())){
            fw.write(json);
            return "INFORMACION GUARDADA";

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "ERROR AL ACEDER AL FICHERO");
        }

    }
}

