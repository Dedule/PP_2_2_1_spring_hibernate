package hiber.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable{
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Column
    private String model;
    @Column
    private int series;

    public Car() {
    }

    public Car(String name, int series) {
        this.model = name;
        this.series = series;
    }

    public Car(User user, String name, int series) {
        this.user = user;
        this.model = name;
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return model;
    }

    public void setName(String name) {
        this.model = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}