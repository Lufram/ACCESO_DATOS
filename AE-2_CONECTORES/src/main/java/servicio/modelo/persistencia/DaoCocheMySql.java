package servicio.modelo.persistencia;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import servicio.Conexion;
import servicio.modelo.entidad.Coche;
import servicio.modelo.entidad.Pasajero;
import servicio.modelo.persistencia.interfaces.DaoCoche;

public class DaoCocheMySql implements DaoCoche {
	
	private Conexion conexionBBDD = new Conexion();
	
	@Override
    public boolean alta(Coche c) {
        if (!conexionBBDD.abrirConexion()) {
            return false;
        }
            boolean alta = true;
            try {
            	String query = "insert into coches (MATRICULA,MARCA,MODELO,COLOR) " + " values(?,?,?,?)";
                if(!validarMatriculaCoche(c.getMatricula())) {
                    // preparamos la query con valores parametrizables(?)
                    PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);
                    ps.setString(1, c.getMatricula());
                    ps.setString(2, c.getMarca());
                    ps.setString(3, c.getModelo());
                    ps.setString(4, c.getColor());

                    int numeroFilasAfectadas = ps.executeUpdate();
                    System.out.println("VEHICULO DADO DE ALTA");
                    if (numeroFilasAfectadas == 0)
                        alta = false;
                }else {
                    System.out.println("Ya existe un vehiculo con esa matricula.");
                    alta = false;
                }
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
		String query = "delete from coches where id = ?";
		try {
			PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);

			ps.setInt(1, id);

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			borrado = false;
			System.out.println("No se ha podido dar de baja" + " el id " + id);
			e.printStackTrace();
		} finally {
			conexionBBDD.cerrarConexion();
		}
		return borrado;
	}

	@Override
	public boolean modificar(Coche c ) {
		if (!conexionBBDD.abrirConexion()) {
			return false;
		}
			boolean modificado = true;
			String query = "update coches set MATRICULA=?, MARCA=?, " + "MODELO=?, COLOR=? WHERE ID=?";
			try {
				if(!validarIdCoche(c.getId())) {
					System.out.println("No existe un coche con ese ID");
					modificado = false;
				 }else{
					 PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);
						ps.setString(1, c.getMatricula());
						ps.setString(2, c.getMarca());
						ps.setString(3, c.getModelo());
						ps.setString(4, c.getColor());
						ps.setInt(5, c.getId());
		
						int numeroFilasAfectadas = ps.executeUpdate();
						System.out.println("VEHICULO ACTUALIZADO");
						if (numeroFilasAfectadas == 0)
							modificado = false;
	             }
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Ya existe un coche con esa matricula");
			} catch (SQLException e) {
				System.out.println("Error al modificar el " + " coche " + c);
				e.printStackTrace();
				modificado = false;
			} finally {
				conexionBBDD.cerrarConexion();
			}
			return modificado;
		} 


	@Override
	public Coche obtener(int id) {
		if (!conexionBBDD.abrirConexion()) {
			return null;
		}
		Coche coche = null;

		String query = "select ID,MATRICULA,MARCA,MODELO,COLOR from coches " + "where id = ?";
		try {
			PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));
				coche.setColor(rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el " + "coche con id " + id);
			e.printStackTrace();
		} finally {
			conexionBBDD.cerrarConexion();
		}
		
		return coche;
		
	}

	@Override
	public List<Coche> listar() {
		if (!conexionBBDD.abrirConexion()) {
			return null;
		}
		List<Coche> listaCoches = new ArrayList<>();

		String query = "select ID,MATRICULA,MARCA,MODELO,COLOR from coches";
		try {
			PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Coche c = new Coche();
				c.setId(rs.getInt(1));
				c.setMatricula(rs.getString(2));
				c.setMarca(rs.getString(3));
				c.setModelo(rs.getString(4));
				c.setColor(rs.getString(5));

				listaCoches.add(c);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener los " + "coches");
			e.printStackTrace();
		} finally {
			conexionBBDD.cerrarConexion();
		}

		return listaCoches;
	}
	
	public List<Pasajero> listarPasajeros(int idCoche) {
		if (!conexionBBDD.abrirConexion()) {
			return null;
		}
		List<Pasajero> lp = new ArrayList<>();

		String query = "select id_pasajeros,NOMBRE,EDAD,PESO from pasajeros WHERE id_coches=?";
		try {
			PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);
			ps.setInt(1, idCoche);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Pasajero p = new Pasajero();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setEdad(rs.getInt(3));
				p.setPeso(rs.getInt(4));

				lp.add(p);
			}
		} catch (SQLException e) {
			System.out.println("error al obtener los pasajeros");
			e.printStackTrace();
		} finally {
			conexionBBDD.cerrarConexion();
		}

		return lp;
	}
	
	public void mostrarCochesConPasajeros() {
		List<Coche> lc = listar();
		for (Coche coche: lc) {
			System.out.println(coche);
			if(listarPasajeros(coche.getId()).isEmpty()) {
				System.out.println("Este coche no tiene pasajeros asociados"
			+ "\n ------------------------------------");
			}else {
				System.out.println("Pasajeros asociados: ");
				System.out.println(listarPasajeros(coche.getId()));
				System.out.println("------------------------------------");
			}
		}
	}
	
	
	public boolean validarIdCoche(int id) {
		if (!conexionBBDD.abrirConexion()) {
			return false;
		}
		int idValidado = 0;
		
		String query = "select ID from coches WHERE ID=?";
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
			e.printStackTrace();
			return false;
		} 
	}
	
	public boolean validarMatriculaCoche(String matricula) {
        if (!conexionBBDD.abrirConexion()) {
            return false;
        }
        String mValidado = null;

        String query = "select MATRICULA from COCHES WHERE MATRICULA=?";
        try {
            PreparedStatement ps = conexionBBDD.getConexion().prepareStatement(query);
            ps.setString(1, matricula);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                mValidado = rs.getString(1);
            }
            if (matricula.equalsIgnoreCase(mValidado)) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}