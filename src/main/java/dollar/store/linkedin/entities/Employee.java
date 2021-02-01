package dollar.store.linkedin.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "firstname")
    String firstName;

    @Column(name = "lastname")
    String lastName;

    @Column(name = "phone")
    String phone;

    public Long getId() {
        return id;
    }

    public String getFristName() {
        return firstName;
    }

    public void setFristName(String fristName) {
        this.firstName = fristName;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee(String firstName, String last_name, String phone) {
        this.firstName = firstName;
        this.lastName = last_name;
        this.phone = phone;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}


