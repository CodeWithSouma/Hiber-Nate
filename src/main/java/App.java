import hibernate.Hibernate;
import model.Alien;
import model.AlienName;
import model.relationship.Laptop;
import model.relationship.Student;
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

        Student student1 = new Student(101,"Soumadip Dey",100);
        Student student2 = new Student(102,"Soumik Nandi",95);
        Student student3 = new Student(103,"Anirban Dey",100);
        Student student4 = new Student(104,"Arijit Das",100);

        Laptop laptop1 = new Laptop(111,"Dell");
        Laptop laptop2 = new Laptop(112,"Hp");
        Laptop laptop3 = new Laptop(113,"MacBook");
        Laptop laptop4 = new Laptop(114,"Sony");
        Laptop laptop5 = new Laptop(115,"Microsoft Surface");

        List<Laptop> listOfLaptop = new ArrayList<>();
        listOfLaptop.add(laptop1);
        listOfLaptop.add(laptop3);
        listOfLaptop.add(laptop4);

        student1.setListOfLaptop(listOfLaptop);
        student2.setListOfLaptop(listOfLaptop);
        student3.setListOfLaptop(listOfLaptop);

        List<Student> listOfStudent = new ArrayList<>();
        listOfStudent.add(student1);
        listOfStudent.add(student2);
        listOfStudent.add(student3);

        laptop1.setListOfStudent(listOfStudent);
        laptop3.setListOfStudent(listOfStudent);
        laptop4.setListOfStudent(listOfStudent);

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session =  sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        
        session.save(laptop1);
        session.save(laptop2);
        session.save(laptop3);
        session.save(laptop4);
        session.save(laptop5);

        transaction.commit();

    }
}
