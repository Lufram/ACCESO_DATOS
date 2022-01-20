package request_one.entity;

import java.io.*;
import java.util.ArrayList;

public class Almacen implements Serializable {

	private static final long serialVersionUID = -1856120338726783342L;
	private static String NOMBRE_FICHERO;

	// Almacena los coches en una lista.
	private ArrayList <Coche> stock;

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

	@Override
	public String toString() {
		return "Almacen{" +
				"stock=" + stock +
				'}';
	}


	// Metodos
	
	/**
	* Devuelve todos los coches que esten en la lista del almacen
	*
	* @param  coche
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
	public Coche getById(int id) {
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
			System.out.println("ERROR" + e);
			return null;
		}
	}
	
	
	/**
	* Devuelve todos los coches que esten en la lista del almacen
	*
	* @return todos los elementos del stock.
	**/
	public ArrayList<Coche> getAll() {
		return stock;
    	}
	
	/**
	* Busca si hay un coche con el Id pasado por parametro y si existe lo elimina de la lista
	*
	* @param id del vehiculo
	* @return cadena con la comfirmacion de la eliminacion y información eliminada o informa que no existe el id si no lo encuentra.
	**/
	public String delByID(int id) {
		Coche c = getById(id);
		if (c == null){
			return "Vehiculo no existe";
		} else {
			stock.remove(c);
			return  "Vehiculo borrado: " + c;
		}
	}

	/**
	* 
	*
	* 
	**/
	public String initFile() {

		try (FileInputStream file = new FileInputStream(NOMBRE_FICHERO);
			 ObjectInputStream buffer = new ObjectInputStream(file);){
			boolean eof = false;
			Coche c;
			while (!eof) {
				try {
					c = (Coche) buffer.readObject();
					stock.add(c);
				} catch (EOFException e1) {
					eof = true;
				} catch (IOException e2) {
					return"Error al leer los coches del almacen" + e2.getMessage();
				} catch (ClassNotFoundException e3) {
					return "La clase Coche no está cargada en memoria" + e3.getMessage();
				}
			}
			return "LISTA DE COCHES ACTIVA";
		} catch (IOException e) {
			return "No se ha podido abrir el almacen de coches: " + e.getMessage();
		}

	}
	
	/**
	* 
	*
	* 
	**/
	public String updateFile() {
		try(FileOutputStream file = new FileOutputStream(NOMBRE_FICHERO, false);
			ObjectOutputStream buffer = new ObjectOutputStream(file)) {
			for(Coche c : stock) {
				buffer.writeObject(c);
			}
			return "INFORMACION ACTUALIZADA EN FICHERO";
		} catch (IOException e) {
			return "FALLO AL ACTUALIZAR" + e.getMessage();
		}
	}
}

