package entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String subname;
    @Temporal(TemporalType.DATE)
    private Date burnDate;

    @OneToMany(mappedBy="autor")
    private List<Book> books;

    public Author() {
    super();
    books = new ArrayList();
    }

    public Author(String name, String sudname, Date burnDate) {
        this.name = name;
        this.subname = sudname;
        this.burnDate = burnDate;
        books = new ArrayList();
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

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
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
        books.add(book);
        book.setAutor(this);
    }

    public void removeBook(Book book) {
        getBooks().remove(book);
        book.setAutor(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author autor = (Author) o;
        return Objects.equals(id, autor.id) && Objects.equals(name, autor.name) && Objects.equals(subname, autor.subname) && Objects.equals(burnDate, autor.burnDate) && Objects.equals(books, autor.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subname, burnDate, books);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sudname='" + subname + '\'' +
                ", burnDate=" + burnDate +
                ", books=" + books +
                '}';
    }
}
