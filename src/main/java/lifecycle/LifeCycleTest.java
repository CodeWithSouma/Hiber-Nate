package lifecycle;

import model.hql.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Random;

public class LifeCycleTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session1 =  sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        /*Random random = new Random();
        for (int i = 1; i <= 50 ; i++) {
            Laptop laptop = new Laptop(i,"Brand "+i,random.nextInt(50000)+25000);
            session1.save(laptop);
        }*/
/*
        Laptop laptop = new Laptop(51,"Dell",55000);// transient state
        session1.save(laptop);// persistence state
        laptop.setBrand("Hp"); // reflect this changes as well as in the database;*/

        Laptop laptop1 = (Laptop) session1.get(Laptop.class,1);// give you object || if object not present it give you null
        System.out.println(laptop1);

        Laptop laptop2 = (Laptop) session1.load(Laptop.class,1);// give you proxy object || but it throws object not found exception
        System.out.println(laptop2);

        transaction1.commit();
        session1.close();
    }
}
