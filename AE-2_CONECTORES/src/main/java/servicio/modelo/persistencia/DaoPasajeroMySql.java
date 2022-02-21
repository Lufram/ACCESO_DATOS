package servicio.modelo.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import servicio.Conexion;
import servicio.modelo.entidad.Coche;
import servicio.modelo.entidad.Pasajero;
import servicio.modelo.persistencia.interfaces.DaoPasajero;

public class DaoPasajeroMySql implements DaoPasajero {
	
	private Conexion conexionBBDD = new Conexion();
	
	
	
	@Override
	public boolean alta(Pasajero p) {
		if (!conexionBBDD.abrirConexion()) {
			return false;
		}
		boolean alta = true;

		String query = "insert into pasajeros (NOMBRE,EDAD,PESO) " + " values(?,?,?)";
		try {
			// preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getEdad());
			ps.setInt(3, p.getPeso());

			int numeroFilasAfectadas = ps.executeUpdate();
			System.out.println("PASAJERO DADO DE ALTA");
			if (numeroFilasAfectadas == 0)
				alta = false;
		} catch (SQLException e) {
			e.printStackTrace();
			alta = false;
		} finally {
			conexionBBDD.cerrarConexion();
		}

		return alta;
	}

	@Override
	public boolean baja(int id) {
		if (!conexionBBDD.abrirConexion()) {
			return false;
		}

		boolean borrado = true;
		String query = "delete from pasajeros where id_pasajeros = ?";
		try {
			PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);

			ps.setInt(1, id);

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			borrado = false;
			System.out.println("baja -> No se ha podido dar de baja" + " el id " + id);
			e.printStackTrace();
		} finally {
			conexionBBDD.cerrarConexion();
		}
		return borrado;
	}


	@Override
	public Pasajero obtener(int id) {
		if (!conexionBBDD.abrirConexion()) {
			return null;
		}
		Pasajero p = null;

		String query = "select id_pasajeros,NOMBRE,EDAD,PESO from pasajeros " + "where id_pasajeros = ?";
		try {
			PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Pasajero();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setEdad(rs.getInt(3));
				p.setPeso(rs.getInt(4));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el " + "pasajero con id " + id);
			e.printStackTrace();
		} finally {
			conexionBBDD.cerrarConexion();
		}
		
		return p;
		
	}

	@Override
	public List<Pasajero> listar() {
		if (!conexionBBDD.abrirConexion()) {
			return null;
		}
		List<Pasajero> listaPasajeros = new ArrayList<>();

		String query = "select id_pasajeros,NOMBRE,EDAD,PESO from pasajeros";
		try {
			PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Pasajero p = new Pasajero();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setEdad(rs.getInt(3));
				p.setPeso(rs.getInt(4));

				listaPasajeros.add(p);
			}
		} catch (SQLException e) {
			System.out.println("error al obtener los pasajeros");
			e.printStackTrace();
		} finally {
			conexionBBDD.cerrarConexion();
		}

		return listaPasajeros;
	}
	
	public boolean anadirPasajero (int id, int id_pasajero ) {
		if (!conexionBBDD.abrirConexion()) {
			return false;
		}
			boolean modificado = true;
			String query = "update pasajeros set ID_COCHES=? WHERE id_pasajeros=?";
			try {
				PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);
				ps.setInt(1, id);
				ps.setInt(2, id_pasajero);

				int numeroFilasAfectadas = ps.executeUpdate();
				System.out.println("PASAJERO ACTUALIZADO");
				if (numeroFilasAfectadas == 0)
					modificado = false;
			} catch (SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Error al modificar el pasajero");
				e.printStackTrace();
				modificado = false;
			} finally {
				conexionBBDD.cerrarConexion();
			}
			return modificado;
		} 
	
	public boolean borrarPasajero (int id, int idPasajero ) {
		if (!conexionBBDD.abrirConexion()) {
			return false;
		}
		
		if(validarPasajeroEnCoche(id, idPasajero) == true) {
			boolean modificado = true;
			String query = "update pasajeros set ID_COCHES=? WHERE id_pasajeros=?";
			try {
				PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);
				ps.setNull(1, Types.INTEGER);
				ps.setInt(2, idPasajero);

				int numeroFilasAfectadas = ps.executeUpdate();
				System.out.println("PASAJERO ACTUALIZADO");
				if (numeroFilasAfectadas == 0)
					modificado = false;
			} catch (SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Error al modificar el pasajero");
				e.printStackTrace();
				modificado = false;
			} finally {
				conexionBBDD.cerrarConexion();
			}
			return modificado;
		}else {
			System.out.println("El pasajero no esta asignado a este coche");
			return false;
		}
		
		}
			
	
	public boolean validarIdPasajero(int id) {
		if (!conexionBBDD.abrirConexion()) {
			return false;
		}
		int idValidado = 0;

		String query = "select id_pasajeros from pasajeros WHERE id_pasajeros=?";
		try {
			PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				idValidado = rs.getInt(1);
			}
			if (idValidado == id) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("error al obtener los pasajeros");
			e.printStackTrace();
			return false;
		} finally {
			conexionBBDD.cerrarConexion();
		}
	}
	
	public boolean validarPasajeroEnCoche(int id, int idPasajero) {
		if (!conexionBBDD.abrirConexion()) {
			return false;
		}
		int idValidado = 0;

		String query = "select id_coches from pasajeros WHERE id_pasajeros=?";
		try {
			PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);
			ps.setInt(1, idPasajero);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				idValidado = rs.getInt(1);
			}
			if (idValidado == id) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("error al obtener los pasajeros");
			e.printStackTrace();
			return false;
		} 
	}
	
}
