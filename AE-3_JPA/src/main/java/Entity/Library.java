package Entity;

import javax.persistence.*;
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
    private Adress adress;


    @ManyToMany(mappedBy="autor", cascade=CascadeType.PERSIST)
    @JoinTable(name="libraries_books",
            joinColumns= { @JoinColumn( name="pk_id_library" ,referencedColumnName="id") },
            inverseJoinColumns= { @JoinColumn( name="fk_id_book", referencedColumnName="id") })
    private List<Book> books;

    public Library() {
        super();
    }

    public Library(String name, String ownerName) {
        this.name = name;
        this.ownerName = ownerName;
    }

    public Library(String name, String ownerName, Adress adress) {
        this.name = name;
        this.ownerName = ownerName;
        updateAdress(adress);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id)
                && Objects.equals(name, library.name)
                && Objects.equals(ownerName, library.ownerName)
                && Objects.equals(adress, library.adress)
                && Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ownerName, adress, books);
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", adress=" + adress +
                ", books=" + books +
                '}';
    }

    public void removeAdress() {
        getAdress().setLibrary(null);
        setAdress(null);
    }

    public void updateAdress(Adress adress) {
        setAdress(adress);
        adress.setLibrary(this);
    }

    public void addBook(Book book) {
        getBooks().add(book);
        book.getLibraries().add(this);
    }

    public void removeBook(Book book) {
        getBooks().remove(book);
        book.getLibraries().remove(this);
    }

}
