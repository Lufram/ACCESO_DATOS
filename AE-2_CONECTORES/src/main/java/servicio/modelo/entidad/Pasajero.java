package servicio.modelo.entidad;

public class Pasajero {
	
	//Variables
	
	private int id;
    private String nombre;
    private int edad;
    private int peso;
    
    //Constructor
    
	public Pasajero() {
		super();
	}
	
	//Getters y Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	@Override
    public String toString() {
        return "Pasajero[" +
                "id=" + id +
                "--- nombre='" + nombre + '\'' +
                "--- edad='" + edad + '\'' +
                "--- peso='" + peso + " kg" +'\'' +
                "]\n";
    }

}
