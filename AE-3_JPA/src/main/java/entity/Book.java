package entity;

import javax.persistence.*;

import java.util.ArrayList;
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
    private Author autor;

    @ManyToMany(mappedBy="books")
    private List<Library> libraries;

    public Book() {
    	libraries = new ArrayList();
    }

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        libraries = new ArrayList();
    }

    public Book(String title, double price, Author autor) {
        this.title = title;
        this.price = price;
        this.autor = autor;
        libraries = new ArrayList();
    }

    public Book(String title, double price, Editorial editorial, Author autor) {
        this.title = title;
        this.price = price;
        this.editorial = editorial;
        this.autor = autor;
        libraries = new ArrayList();
    }

    public Book(Integer id,String title, double price, Editorial editorial, Author autor) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.editorial = editorial;
        this.autor = autor;
        libraries = new ArrayList();
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

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + "]\n";
	}
    
}
