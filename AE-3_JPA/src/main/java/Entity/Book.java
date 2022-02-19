package Entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private double price;

    @ManyToOne
    @JoinColumn(name="fk_id_editorial", referencedColumnName="id")
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name="fk_id_autor", referencedColumnName="id")
    private Autor autor;

    @ManyToMany(mappedBy="books", cascade=CascadeType.PERSIST)
    private List<Library> libraries;

    public Book() {

    }

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Book(String title, double price, Autor autor) {
        this.title = title;
        this.price = price;
        this.autor = autor;
    }

    public Book(String title, double price, Editorial editorial, Autor autor) {
        this.title = title;
        this.price = price;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Book(Integer id,String title, double price, Editorial editorial, Autor autor) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }
}
