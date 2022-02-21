package entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String ownerName;

    @Embedded
    private Address address;

    @ManyToMany
   		@JoinTable(name="libraries_books",
            joinColumns= { @JoinColumn( name="fk_id_library" ,referencedColumnName="id") },
            inverseJoinColumns= { @JoinColumn( name="fk_id_book", referencedColumnName="id") })
    private List<Book> books;

    public Library() {
        super();
        books = new ArrayList();
    }

    public Library(String name, String ownerName) {
        this.name = name;
        this.ownerName = ownerName;
        books = new ArrayList();
    }

    public Library(String name, String ownerName, Address address) {
        this.name = name;
        this.ownerName = ownerName;
        this.address = address;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Address getAdress() {
        return address;
    }

    public void setAdress(Address adress) {
        this.address = adress;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id)
                && Objects.equals(name, library.name)
                && Objects.equals(ownerName, library.ownerName)
                && Objects.equals(address, library.address)
                && Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ownerName, address, books);
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", adress=" + address +
                ", books=" + books +
                '}';
    }

    public void addBook(Book book) {
        books.add(book);
        book.getLibraries().add(this);
    }

    public void removeBook(Book book) {
        getBooks().remove(book);
        book.getLibraries().remove(this);
    }

}
