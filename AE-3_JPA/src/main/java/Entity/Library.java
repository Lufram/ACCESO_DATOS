package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
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

    public Library(String name, String ownerName, Adress adress) {
        this.name = name;
        this.ownerName = ownerName;
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
}
