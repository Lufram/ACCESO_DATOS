package servicio.modelo.entidad;

public class Coche {

    // Variables


	private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    
    //Constructor
    
    public Coche() {
    	super();
    	
    }
    
    //toString
    
    @Override
    public String toString() {
        return "Coche[" +
                "id=" + id +
                "--- matricula='" + matricula + '\'' +
                "--- marca='" + marca + '\'' +
                "--- modelo='" + modelo + '\'' +
                "--- color='" + color + '\'' +
                "]\n";
    }

    // Getters y setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
