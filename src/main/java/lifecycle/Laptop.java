package lifecycle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Laptop_Table")
public class Laptop {
    @Id
    private int lid;
    private String brand;
    private int price;

    public Laptop() {
    }

    public Laptop(int lid, String brand, int price) {
        this.lid = lid;
        this.brand = brand;
        this.price = price;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
