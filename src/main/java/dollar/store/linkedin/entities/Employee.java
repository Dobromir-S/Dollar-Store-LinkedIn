package dollar.store.linkedin.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    String fristName;

    @Column(name = "last_name")
    String last_name;

    public Long getId() {
        return id;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Employee(String fristName, String last_name) {
        this.fristName = fristName;
        this.last_name = last_name;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fristName='" + fristName + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}


