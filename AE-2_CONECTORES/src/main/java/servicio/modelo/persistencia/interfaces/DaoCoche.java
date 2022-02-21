package servicio.modelo.persistencia.interfaces;

import java.util.List;

import servicio.modelo.entidad.Coche;

public interface DaoCoche {
	public boolean alta(Coche c);
	public boolean baja(int id);
	public boolean modificar(Coche c);
	public Coche obtener(int id);
	public List<Coche> listar();
}
