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

    public Employee(String fristName, String last_name) {
        this.firstName = fristName;
        this.lastName = last_name;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fristName='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                '}';
    }
}


