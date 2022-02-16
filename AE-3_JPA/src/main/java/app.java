import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class app {

    @SuppressWarnings("unchecked")
    public static void main(String[] args){

        emf = Persistence.createEntityManagerFactory("PruebaJPARelaciones");

        iniciarBBDD();

        em = emf.createEntityManager();
    }
}

