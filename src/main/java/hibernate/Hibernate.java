package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Hibernate {

    public Session configure(Class className){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(className);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        return sessionFactory.openSession();
    }

    public Transaction startTransaction(Session session){
       return session.beginTransaction();
    }
}
