package servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public class Conexion {
	
	private Connection conexion;
	
	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public boolean crearBBDD() {
        if(!abrirConexion()){
            return false;
        }
        boolean estaCreada = true;
        
        try {
            //Con esto creamos una bbdd enbebida dentro del proyecto 
            Statement state = conexion.createStatement();
            state.execute("create table coches(id INT NOT NULL AUTO_INCREMENT, " 
                    + "matricula varchar(30) UNIQUE, " 
                    + "marca varchar(30), " 
                    + "modelo varchar(30),"
                    + "color varchar(30),"
                    + "CONSTRAINT primary_key PRIMARY KEY (id)"
                    + ")");
            state.execute("create table pasajeros(id_pasajeros INT NOT NULL AUTO_INCREMENT, "
                    + "nombre varchar(30), "
                    + "edad INT(30), "
                    + "peso INT(30), "
                    + "id_coches INT(30), "
                    + "CONSTRAINT primary_key_pasajeros PRIMARY KEY (id_pasajeros),"
                    + "CONSTRAINT foreign_key FOREIGN KEY (id_coches) REFERENCES coches(id) "
                    + ")");
            
        } catch (SQLSyntaxErrorException e) {  
        	System.out.println("Abriendo la base de datos existente");
        	estaCreada = false;
        } catch (SQLException e) {
            e.printStackTrace();
            estaCreada = false;
        } finally{
            cerrarConexion();
        }
        
        return estaCreada;
    }

	public boolean abrirConexion() {
		String url = "jdbc:mysql://localhost:3306/manejodeconectores";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
