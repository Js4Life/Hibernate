import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class main {

    public static void main(String[] args) {

        System.out.println("hello");

     //   Alien telusko = null;

        AlienName an = new AlienName();

        an.setFname("RaghavendraGowda");
        an.setLname("Ashwin");
        an.setMname("Sagir");

        Alien telusko = new Alien();

       telusko.setAid(101);
      // telusko.setAname("Sarang");
        telusko.setAname(an);
        telusko.setColor("Green");


        Laptop laptop = new Laptop();

        laptop.setLid(101);
        laptop.setLname("Dell");



        Student s = new Student();

        s.setName("Ashwin");
        s.setRollno(1);
        s.setMarks(50);
       // s.setLaptop(laptop); for one to one

        s.getLaptop().add(laptop);

        laptop.getStudent().add(s);



        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

     //   telusko = (Alien) session.get(Alien.class,104);

      //  session.save(telusko);

        session.save(laptop);
        session.save(s);

        tx.commit();



      //  System.out.println(telusko);


    }
}
