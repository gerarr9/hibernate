package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "city_name", nullable = false)
    private String nameCity;
    @OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public City(long id, String nameCity) {
        this.id = id;
        this.nameCity = nameCity;
    }

    public City(String nameCity) {
        this.nameCity = nameCity;
    }
    public City() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", nameCity='" + nameCity + '\'' +
                '}';
    }
}
