package entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String surname;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City cityId;

    public Employee() {

    }

    public Employee(String name, String surname, String gender, int age) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public Employee(String name, String surname, String gender, int age, City cityId) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", cityId=" + cityId +
                '}';
    }
}
