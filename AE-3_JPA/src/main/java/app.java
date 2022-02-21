
import entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class app {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		initBBDD();
		consultBBDD();
		closeConexion();
	}

	public static void initBBDD() {

		emf = Persistence.createEntityManagerFactory("PruebaJPARelaciones");
		em = emf.createEntityManager();

		// Creamos las direcciones.
		Address adress1 = new Address("Calle", "Travessera de Gracia", 47, "Barcelona");
		Address adress2 = new Address("Calle", "Bailen", 8, "Barcelona");
		Address adress3 = new Address("Calle", "del Espejo", 5, "Madrid");
		Address adress4 = new Address("Calle", "de Mallorca", 237, "Barcelona");

		// Creamos las editoriales y le pasamos la dirección al constructor.
		Editorial edit1 = new Editorial("Debolsillo", adress1);
		Editorial edit2 = new Editorial("Gigamesh", adress2);

		// Creamos las librerias.
		Library library1 = new Library("Menosdiez", "Andrea Lannivi", adress3);
		Library library2 = new Library("La central", "Alberto Ramirez", adress4);

		// Creamos los autores
		Author autor1 = new Author("Terry", "Pratchett", null);
		Author autor2 = new Author("Patrick", "Rothfuss", null);
		Author autor3 = new Author("George", "R.R. Martin", null);

		// Fechas Nacimiento autores
		try {
			autor1.setBurnDate(new SimpleDateFormat("yyyy-MM-dd").parse("1948-04-15"));
			autor2.setBurnDate(new SimpleDateFormat("yyyy-MM-dd").parse("1973-06-06"));
			autor3.setBurnDate(new SimpleDateFormat("yyyy-MM-dd").parse("1939-11-07"));

		} catch (ParseException p) {
			System.out.println(p);
		}

		// Creamos varios libros y pasamos el autor por constructor.
		Book l1 = new Book("Mort", 19.90, edit1, autor1);
		Book l2 = new Book("El color de la magia", 19.90, edit1, autor1);
		Book l3 = new Book("El segador", 19.90, edit1, autor1);
		Book l4 = new Book("Sould music", 19.90, edit1, autor1);
		Book l5 = new Book("Good omens", 28.90, edit1, autor1);
		Book l6 = new Book("El hadron del tiempo", 19.90, edit1, autor1);
		Book l7 = new Book("Papa puerco", 19.90, edit1, autor1);

		// Como es bidireccional añadimos al Autor los libros.
		autor1.addBook(l1);
		autor1.addBook(l2);
		autor1.addBook(l3);
		autor1.addBook(l4);
		autor1.addBook(l5);
		autor1.addBook(l6);
		autor1.addBook(l7);

		// Creamos varios libros y pasamos el autor por constructor.
		Book l8 = new Book("El nombre del viento", 36.90, edit1, autor2);
		Book l9 = new Book("El temor de un Hombre sabio", 41.90, edit1, autor2);
		Book l10 = new Book("La music del silencio", 19.90, edit1, autor2);

		// Como es bidireccional añadimos al Autor los libros.
		autor2.addBook(l8);
		autor2.addBook(l9);
		autor2.addBook(l10);

		// Creamos varios libros y pasamos el autor por constructor.
		Book l11 = new Book("Juego de tronos", 38.90, edit2, autor3);
		Book l12 = new Book("Choque de reyes", 38.90, edit2, autor3);
		Book l13 = new Book("Tormenta de espadas", 42.90, edit2, autor3);
		Book l14 = new Book("Festin de cuervos", 46.90, edit2, autor3);
		Book l15 = new Book("Danza de dragones", 54.90, edit2, autor3);
		Book l16 = new Book("Vientos de Invierno", 19.90, edit2, autor3);
		Book l17 = new Book("Sueno de primavera", 19.90, edit2, autor3);

		// Como es bidireccional añadimos al Autor los libros.
		autor3.addBook(l11);
		autor3.addBook(l12);
		autor3.addBook(l13);
		autor3.addBook(l14);
		autor3.addBook(l15);
		autor3.addBook(l16);
		autor3.addBook(l17);

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

		// Añadimos los libros a la librería y a los libros la librería
		library2.addBook(l11);
		library2.addBook(l12);
		library2.addBook(l13);
		library2.addBook(l14);
		library2.addBook(l15);
		library2.addBook(l16);
		library2.addBook(l17);

		em.getTransaction().begin();
		em.persist(library1);
		em.persist(library2);
		em.persist(edit1);
		em.persist(edit2);
		em.persist(autor1);
		em.persist(autor2);
		em.persist(autor3);
		em.persist(l1);
		em.persist(l2);
		em.persist(l3);
		em.persist(l4);
		em.persist(l5);
		em.persist(l6);
		em.persist(l7);
		em.persist(l8);
		em.persist(l9);
		em.persist(l10);
		em.persist(l11);
		em.persist(l12);
		em.persist(l13);
		em.persist(l14);
		em.persist(l15);
		em.persist(l16);
		em.persist(l17);
		em.getTransaction().commit();

	}

	public static void consultBBDD() {

		System.out.println("-----------------------------------\n"
				+ "Libros dados de alta, con su editorial y su autor\n" + "-----------------------------------");

		Query query1 = em.createQuery("Select b from Book b");
		List<Book> bookList = query1.getResultList();
		listBooks(bookList);

		System.out.println("-----------------------------------\n"
				+ "Autores dados de alta, con sus libros asociados\n" + "-----------------------------------");

		Query query2 = em.createQuery("Select a from Author a");
		List<Author> authorList = query2.getResultList();

		listAuthors(authorList);
		
		System.out.println("-----------------------------------\n"
				+ "Librerias con sus libros asociados\n" + "-----------------------------------");

		Query query3 = em.createQuery("Select l from Library l");
		List<Library> libraryList = query3.getResultList();

		listLibraries(libraryList);
		
		System.out.println("-----------------------------------\n"
				+ "Librerias con sus libros asociados\n" + "-----------------------------------");

		Query query4 = em.createQuery("Select b from Book b");
		List<Book> bookList2 = query4.getResultList();

		listBooks2(bookList2);
	}

	public static void listBooks(List<Book> bookList) {
		for (Book b : bookList) {
			System.out.println("Libro -> id = " + b.getId() + ", title = " + b.getTitle()
					+ ", autor = " + b.getAutor().getName() + " " + b.getAutor().getSubname() + ", editorial = "
					+ b.getEditorial().getName());
		}
	}
	
	public static void listAuthors(List<Author> authorList) {
		for (Author a : authorList) {
			System.out.println("Autor -> id = " + a.getId() + ", nombre = " + a.getName() + " " + a.getSubname() 
			+ "\nLibros asociados = " + a.getBooks());
		}
	}
	
	public static void listLibraries(List<Library> libraryList) {
		for (Library l : libraryList) {
			System.out.println("Libreria -> id = " + l.getId() + ", nombre = " + l.getName()
			+ "\nLibros asociados = " + l.getBooks());
		}
	}
	
	public static void listBooks2(List<Book> bookList) {
		for (Book b : bookList) {
			for(int i = 0; i < b.getLibraries().size(); i++) {
				System.out.println("Libro -> id = " + b.getId() + ", titulo = " + b.getTitle()
				+ ", libreria = " + b.getLibraries().get(i).getName());
			}
			
		}
	}
	
	public static void closeConexion() {
		em.close();
		emf.close();
	}
}
