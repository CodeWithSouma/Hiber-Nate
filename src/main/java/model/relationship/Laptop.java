package model.relationship;

import model.Alien;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Laptop {
    @Id
    private int lid;
    private String lname;
    private int price;
    @ManyToOne
    private Alien alien;

    public Laptop() {
    }

    public Laptop(int lid, String lname, int price) {
        this.lid = lid;
        this.lname = lname;
        this.price = price;
    }

    public Laptop(int lid, String lname, int price, Alien alien) {
        this.lid = lid;
        this.lname = lname;
        this.price = price;
        this.alien = alien;
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

    public Alien getAlien() {
        return alien;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
