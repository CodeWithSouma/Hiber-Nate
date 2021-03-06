package model;

import model.relationship.Laptop;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Alien { //POJO
    @Id
    private int aid;
    private String aname;
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "alien",fetch = FetchType.EAGER)
    private List<Laptop> listOfLaptop;

    public Alien() {
    }

    public Alien(int aid, String aname) {
        this.aid = aid;
        this.aname = aname;
    }

    public Alien(int aid, String aname, List<Laptop> listOfLaptop) {
        this.aid = aid;
        this.aname = aname;
        this.listOfLaptop = listOfLaptop;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public List<Laptop> getListOfLaptop() {
        return listOfLaptop;
    }

    public void setListOfLaptop(List<Laptop> listOfLaptop) {
        this.listOfLaptop = listOfLaptop;
    }

}
