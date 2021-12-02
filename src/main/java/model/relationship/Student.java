package model.relationship;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
   @Id
   private int roll;
   private String name;
   private int marks;
   @OneToMany(mappedBy = "student")
   private List<Laptop> listOfLaptop = new ArrayList<Laptop>();


    public Student(int roll, String name, int marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    public Student(int roll, String name, int marks, List<Laptop> listOfLaptop) {
        this(roll, name, marks);
        this.listOfLaptop = listOfLaptop;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public List<Laptop> getListOfLaptop() {
        return listOfLaptop;
    }

    public void setListOfLaptop(List<Laptop> listOfLaptop) {
        this.listOfLaptop = listOfLaptop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", listOfLaptop=" + listOfLaptop +
                '}';
    }
}
