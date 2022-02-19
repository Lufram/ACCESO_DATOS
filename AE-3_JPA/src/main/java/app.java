
import Entity.*;
import org.hibernate.ejb.HibernatePersistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class app {

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AE3JPA");
        EntityManager em =  null;
        initBBDD();
        em = emf.createEntityManager();
    }

    public static void  initBBDD(){

        // Creamos una nueva dirección.
        Adress adress1 = new Adress( "Calle", "Travessera de Gracia", 47, "Barcelona");

        // Creamos una Editorial y le pasamos la dirección al constructor.
        Editorial edit1 = new Editorial( "Debolsillo", adress1);

        // Creamos un Autor.
        Autor autor1 = new Autor ("Terry", "Pratchett", 28/04/1948);

        // Creamos varios libros y pasamos el autor por constructor.
        Book l1 = new Book( "Mort", 19.90, autor1);
        Book l2 = new Book( "El color de la magia", 19.90, autor1);
        Book l3 = new Book("El segador", 19.90, autor1);
        Book l4 = new Book("Sould music", 19.90, autor1);
        Book l5 = new Book("Good omens", 28.90, autor1 );
        Book l6 = new Book("El hadron del tiempo", 19.90, autor1);
        Book l7 = new Book("Papa puerco", 19.90, autor1);

        // Como es bidireccional añadimos al Autor los libros.
        autor1.addBook(l1);
        autor1.addBook(l2);
        autor1.addBook(l3);
        autor1.addBook(l4);
        autor1.addBook(l5);
        autor1.addBook(l6);
        autor1.addBook(l7);

        // Creamos un Autor.
        Autor autor2 = new Autor ("Patrick", "Rothfuss", 06/06/1973);

        // Creamos varios libros y pasamos el autor por constructor.
        Book l8 = new Book("El nombre del viento", 36.90, autor2);
        Book l9 = new Book( "El temor de un Hombre sabio", 41.90, autor2);
        Book l10 = new Book("La music del silencio", 19.90, autor2);

        // Como es bidireccional añadimos al Autor los libros.
        autor2.addBook(l8);
        autor2.addBook(l9);
        autor2.addBook(l10);

        // Creamos una nueva dirección.
        Adress adress2 = new Adress( "Calle", "Bailen", 8, "Barcelona");

        // Creamos una Editorial y le pasamos la dirección al constructor.
        Editorial edit2 = new Editorial( "Gigamesh",adress2);

        // Creamos un Autor.
        Autor autor3 = new Autor ("George", "R.R. Martin", 20/09/1948);

        // Creamos varios libros y pasamos el autor por constructor.
        Book l11 = new Book("Juego de tronos", 38.90,autor3);
        Book l12 = new Book( "Choque de reyes", 38.90,autor3);
        Book l13 = new Book( "Tormenta de espadas", 42.90,autor3);
        Book l14 = new Book( "Festin de cuervos", 46.90, autor3);
        Book l15 = new Book( "Danza de dragones", 54.90, autor3);
        Book l16 = new Book( "Vientos de Invierno", 19.90,autor3);
        Book l17 = new Book( "Sueno de primavera", 19.90,autor3);

        // Como es bidireccional añadimos al Autor los libros.
        autor3.addBook(l11);
        autor3.addBook(l12);
        autor3.addBook(l13);
        autor3.addBook(l14);
        autor3.addBook(l15);
        autor3.addBook(l16);
        autor3.addBook(l17);

        // Creamos una nueva dirección.
        Adress adress3 = new Adress( "Calle", "del Espejo", 5, "Madrid");

        // Creamos una nueva libreria
        Library library1 = new Library("Menosdiez","Andrea Lannivi",  adress3);

        // Añadimos los libros a la librería
        library1.addBook(l1);
        library1.addBook(l2);
        library1.addBook(l3);
        library1.addBook(l4);
        library1.addBook(l5);
        library1.addBook(l6);
        library1.addBook(l7);
        library1.addBook(l8);
        library1.addBook(l9);
        library1.addBook(l10);

        // Creamos una nueva dirección.
        Adress adress4 = new Adress( "Calle", "de Mallorca", 237, "Barcelona");

        // Creamos una nueva libreria
        Library library2 = new Library( "La central","Alberto Ramirez", adress4);

        // Añadimos los libros a la librería y a los libros la librería
        library2.addBook(l11);
        library2.addBook(l12);
        library2.addBook(l13);
        library2.addBook(l14);
        library2.addBook(l15);
        library2.addBook(l16);
        library2.addBook(l17);
    }
}

