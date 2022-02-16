package Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
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
}
