package request_one.entity;

import java.io.Serializable;

public class Coche implements Serializable {

    private static final long serialVersionUID = 884331241851833410L;
    // Variables
    private int id;
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

    public Coche(int id, String matricula, String marca, String modelo, String color){
        super();
        id = this.getId();
        matricula = this.getMatricula();
        marca = this.getMarca();
        modelo = this.getModelo();
        color = this.getColor();
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                '}';
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
}
