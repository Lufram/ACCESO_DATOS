package Controller;

import Entity.Autor;
import Entity.Book;
import Entity.Editorial;
import org.hibernate.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BookController {

    private final EntityManager em;

    public BookController(EntityManager em) {
        this.em = em;
    }

    public void addItem(String title, double price, Autor autor, Editorial editorial) {

        Book b = new Book();
        b.setTitle(title);
        b.setPrice(price);
        b.setAutor(autor);
        b.setEditorial(editorial);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(b);
        et.commit();

        em.close();
    }

    public void updateItem( Integer id, String title, double price, Autor autor, Editorial editorial) {

        Book b = new Book();
        b.setId(id);
        b.setTitle(title);
        b.setPrice(price);
        b.setAutor(autor);
        b.setEditorial(editorial);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(b);
        et.commit();

    }

    public int deleteItem(Integer id) {

        Book b = getItemById(id);
        if(b != null){
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(b);
            et.commit();
            System.out.println("Libro borrado" + b);
            return 2;
        } else {
            System.out.println("El libro no existe");
            return 1;
        }

    }


    public Book getItemById (Integer id) {
        Book b = em.find(Book.class, id);
        return b;
    }


    public List<Book> getItemByName (String title) {

        Query query = (Query) em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :title" );
        query.setParameter("title", title);
        List<Book> list = query.list();

        return list;
    }


    public List<Book> listSubItems () {

        Query query = (Query) em.createQuery("FROM Books b");
        List<Book> list = query.list();


        return list;
    }

}
