package Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "editorials")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Embedded
    private Adress adress;

    @OneToMany(mappedBy="books")
    private List<Book> books;

    public Editorial() {
        super();
    }

    public Editorial(String name) {
        this.name = name;
    }

    public Editorial(String name, Adress adress) {
        this.name = name;
        this.adress = adress;
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public void addBook(Book book) {
        getBooks().add(book);
        book.setEditorial(this);
    }

    public void removeBook(Book book) {
        getBooks().remove(book);
        book.setEditorial(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Editorial)) return false;
        Editorial editorial = (Editorial) o;
        return Objects.equals(id, editorial.id) && Objects.equals(name, editorial.name) && Objects.equals(adress, editorial.adress) && Objects.equals(books, editorial.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, adress, books);
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress=" + adress +
                ", books=" + books +
                '}';
    }
}
