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
        /*Query query = session1.createQuery("FROM Employee WHERE point >= 50");
        List<Employee> employeeList = query.list();
        for (Employee e:employeeList)
            System.out.println(e);
        System.out.println("Total Student: "+employeeList.size());*/

      /*Query query = session1.createQuery("SELECT empId, name, point FROM Employee  WHERE empId=1");
        Object[] result = (Object[]) query.uniqueResult();
        for(Object obj : result)
            System.out.println(obj);*/

       /* Query query = session1.createQuery("SELECT empId, name, point FROM Employee");
        List<Object[]> tableOfRecords = (List<Object[]>) query.list();
        for (Object[] row: tableOfRecords) {
            System.out.println(row[0]+" "+row[1]+" "+row[2]);
        }*/

        int point = 50;
        Query query = session1.createQuery("SELECT SUM(point) FROM Employee WHERE point > :point");
        query.setParameter("point",point);
        long totalPoint = (long) query.uniqueResult();
        System.out.println("Total point: "+totalPoint);
        
        transaction1.commit();
        session1.close();
    }
}
