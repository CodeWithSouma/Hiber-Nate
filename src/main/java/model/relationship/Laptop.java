package model.relationship;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {
    @Id
    private int lid;
    private String lname;
    @ManyToMany
    private List<Student> listOfStudent = new ArrayList<>();

    public Laptop(int lid, String lname) {
        this.lid = lid;
        this.lname = lname;
    }

    public Laptop(int lid, String lname, List<Student> listOfStudent){
        this(lid,lname);
        this.listOfStudent = listOfStudent;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public List<Student> getListOfStudent() {
        return listOfStudent;
    }

    public void setListOfStudent(List<Student> listOfStudent) {
        this.listOfStudent = listOfStudent;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", listOfStudent=" + listOfStudent +
                '}';
    }
}
