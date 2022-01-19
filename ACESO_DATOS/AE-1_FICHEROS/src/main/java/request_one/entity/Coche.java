package main.java.request_one.entity;

public class Coche {
    // Variables
    private Long id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;

    // Constructor
    public Coche() {
        super();
    }
    public Coche(String matricula, String marca, String modelo, String color){
        super();
        matricula = this.getMatricula();
        marca = this.getMarca();
        modelo = this.getModelo();
        color = this.getColor();
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

    public Long getId() {
        return id;
    }
}
