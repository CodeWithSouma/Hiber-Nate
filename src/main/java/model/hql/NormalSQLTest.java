package model.hql;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class NormalSQLTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session1 =  sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();

        /*SQLQuery query = session1.createSQLQuery("SELECT * FROM Employee");
        query.addEntity(Employee.class);
        List<Employee> employeeList = (List<Employee>) query.list();
        for (Employee emp: employeeList) {
            System.out.println(emp);
        }*/

        // Native queries
        SQLQuery query = session1.createSQLQuery("SELECT empId, name FROM Employee WHERE point > 50");
        List<Object[]> records = (List<Object[]>) query.list();
        for (Object[] record : records) {
            System.out.println(record[0]+" "+record[1]);
        }
        transaction1.commit();
        session1.close();
    }
}
