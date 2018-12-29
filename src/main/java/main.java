import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Collection;

public class main {

    public static void main(String[] args) {


    Alien a = null;


        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();

        session.beginTransaction();

        Query q1 = session.createQuery("from Alien where aid=101");
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();


        System.out.println(a);

// level 1 caching

    //    a = (Alien) session.get(Alien.class,101) ;
     //   System.out.println(a);
        session.getTransaction().commit();
        session.close();


        Session session2 = sf.openSession();
        session2.beginTransaction();
        Query q2 = session2.createQuery("from Alien where aid=101");
        q2.setCacheable(true);
        a = (Alien) q2.uniqueResult();
        System.out.println(a);

    //    a = (Alien) session2.get(Alien.class,101) ;
     //   System.out.println(a);
        session2.getTransaction().commit();
        session2.close();



      //  Alien a1 = (Alien) session.get(Alien.class,1);

    //    System.out.println(a1.getAname());

//        Collection<Laptop> laps = a1.getLaps();
//
//        for (Laptop l:laps) {
//            System.out.println(l);
//        }





    }
}
