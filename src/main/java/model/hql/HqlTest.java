package model.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;
import java.util.Random;

public class HqlTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session1 =  sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        Query query = session1.createQuery("FROM Employee WHERE point >= 50");
        List<Employee> employeeList = query.list();
        for (Employee e:employeeList)
            System.out.println(e);
        System.out.println("Total Student: "+employeeList.size());
        transaction1.commit();
        session1.close();
    }
}
