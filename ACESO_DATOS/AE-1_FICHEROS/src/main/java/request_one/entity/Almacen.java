package main.java.request_one.entity;

import java.io.*;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
	
	/**
	* Devuelve todos los coches que esten en la lista del almacen
	*
	* @param Objeto coche
	**/
	public void addItem(Coche coche) {
		stock.add(coche);
		System.out.println("VEHICULO DADO DE ALTA");
	}
	
	/**
	* Busca en la lista un coche por el id
	*
	* @param id del coche 
	* @return objeto coche
	**/
	public Coche getForID(Int id) {
		try {
			Coche c = null;
			for(Coche n: stock) {
				if (id == n.getId()) {
					c = n;
					break;
				}
			}
			return c;	
			

		} catch (IndexOutOfBoundsException e) {
			System.out.println("ERROR" + e)
			return null
		}
	}
	
	
	/**
	* Devuelve todos los coches que esten en la lista del almacen
	*
	* @return todos los elementos del stock.
	**/
	public List<Coche> getAll() {
		return stock;
    	}
	
	/**
	* Busca si hay un coche con el Id pasado por parametro y si existe lo elimina de la lista
	*
	* @param Id del vehiculo
	* @return cadena con la comfirmacion de la eliminacion y información eliminada o informa que no existe el id si no lo encuentra.
	**/
	public String delForID(Int id) {
		Coche c = getForID(id)
		if (c == null){
			return "DELETE -> ID NO EXISTE: " + id;	
		} else {
			stock.remove(c);
			System.out.println("VEHICULO ELIMINADO" + c);
		}
	}

	/**
	* 
	*
	* 
	**/
	public void initFile() {
        
		try (FileReader fr = new FileReader(NOMBRE_FICHERO);
		BufferedReader br = new BufferedReader(fr);) {

		String json = br.readLine();
		Gson gson = new Gson();
		List<Coche> stock = gson.fromJson(json, new TypeToken<List<Coche>>(){}.getType());
			//Persona p = gson.fromJson(json, Persona.class);
			for(Coche c : stock) {
				addItem(c);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	* 
	*
	* 
	**/
	public void updateFile() {
		
		Gson gson = new Gson();
		String json = gson.toJson(stock);
	    
		try(FileWriter fw = new FileWriter(NOMBRE_FICHERO)){
			
			fw.write(json);
			System.out.println("Fichero creado");
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

