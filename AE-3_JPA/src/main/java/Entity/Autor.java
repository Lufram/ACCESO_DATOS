package Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "autors")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String sudname;
    private Date burnDate;

    @OneToMany(mappedBy="autor")
    private List<Book> books;

    public Autor() {
    super();
    }

    public Autor(String name, String sudname, Date burnDate) {
        this.name = name;
        this.sudname = sudname;
        this.burnDate = burnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSudname() {
        return sudname;
    }

    public void setSudname(String sudname) {
        this.sudname = sudname;
    }

    public Date getBurnDate() {
        return burnDate;
    }

    public void setBurnDate(Date burnDate) {
        this.burnDate = burnDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public void addBook(Book book) {
        getBooks().add(book);
        book.setAutor(this);
    }

    public void removeBook(Book book) {
        getBooks().remove(book);
        book.setAutor(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) && Objects.equals(name, autor.name) && Objects.equals(sudname, autor.sudname) && Objects.equals(burnDate, autor.burnDate) && Objects.equals(books, autor.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sudname, burnDate, books);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sudname='" + sudname + '\'' +
                ", burnDate=" + burnDate +
                ", books=" + books +
                '}';
    }
}
