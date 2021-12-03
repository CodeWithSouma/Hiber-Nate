import model.Alien;
import model.relationship.Laptop;
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
        Session session =  sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        /*session.save(laptop1);
        session.save(laptop2);
        session.save(laptop3);
        session.save(laptop4);
        session.save(laptop5);

        session.save(alien1);
        session.save(alien2);
        session.save(alien3);*/

        Alien alien = (Alien) session.get(Alien.class,101);
        transaction.commit();

    }
}
