package servicio.modelo.persistencia.interfaces;

import java.util.List;

import servicio.modelo.entidad.Pasajero;



public interface DaoPasajero {

		public boolean alta(Pasajero p);
		public boolean baja(int id);
		public Pasajero obtener(int id);
		public List<Pasajero> listar();

}
