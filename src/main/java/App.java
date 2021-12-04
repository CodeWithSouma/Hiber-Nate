import model.Alien;
import model.relationship.Laptop;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Alien alien1 = new Alien(101,"Navin");
        Alien alien2 = new Alien(102,"Rahul");
        Alien alien3 = new Alien(103,"Mayank");

        Laptop laptop1 = new Laptop(111,"Dell", 35_000, alien1);
        Laptop laptop2 = new Laptop(112,"Hp", 40_000, alien1);
        Laptop laptop3 = new Laptop(113,"MacBook", 90_000, alien1);
        Laptop laptop4 = new Laptop(114,"Sony", 30_000, alien3);
        Laptop laptop5 = new Laptop(115,"Microsoft Surface", 85_000, alien3);

        List<Laptop> listOfLaptop1 = new ArrayList<>();
        listOfLaptop1.add(laptop1);
        listOfLaptop1.add(laptop2);
        listOfLaptop1.add(laptop3);

        alien1.setListOfLaptop(listOfLaptop1);

        List<Laptop> listOfLaptop2 = new ArrayList<>();
        listOfLaptop2.add(laptop4);
        listOfLaptop2.add(laptop5);

        alien3.setListOfLaptop(listOfLaptop2);


        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session1 =  sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        Query query1 = session1.createQuery("from Alien where aid=101");
        query1.setCacheable(true);
        /*session1.save(laptop1);
        session1.save(laptop2);
        session1.save(laptop3);
        session1.save(laptop4);
        session1.save(laptop5);

        session1.save(alien1);
        session1.save(alien2);
        session1.save(alien3);*/

//        Alien alien = (Alien) session1.get(Alien.class,101);
        Alien alien = (Alien) query1.uniqueResult();
        System.out.println(alien.getAname());
        transaction1.commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();
        Query query2 = session2.createQuery("from Alien where aid=101");
        query2.setCacheable(true);
//        alien = (Alien) session2.get(Alien.class,101);
        alien = (Alien) query2.uniqueResult();
        System.out.println(alien.getAname());
        transaction2.commit();
        session2.close();





    }
}
