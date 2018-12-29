import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Alien alien = entityManager.find(Alien.class,1);
        entityManager.getTransaction().begin();
        //    entityManager.persist();
        entityManager.getTransaction().commit();


//
//    Alien a = null;
//
//
//        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
//
//        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
//
//        SessionFactory sf = con.buildSessionFactory(reg);
//
//        Session session = sf.openSession();
//
//        session.beginTransaction();
//
//        Alien alien = new Alien();
//        alien.setAid(1);
//        alien.setAname("ashwin");
//        alien.setColor("yellow");
//
//        session.save(alien);
//
//
//
//        session.getTransaction().commit();
//        session.close();






    }
}
