package dollar.store.linkedin.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;

@Entity
@Table(name = "joboffer")
public class JobOffer {

    public JobOffer() {

    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public JobType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getSalary() {
        return salary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private JobType type;

    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private int salary;

    public JobOffer(String company, String title, JobType type, String description, int salary) {
        this.company = company;
        this.title = title;
        this.type = type;
        this.description = description;
        this.salary = salary;
    }

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    Collection<Employee> applicants = new LinkedHashSet<>();

    public void addApplicants(Employee e){
        applicants.add(e);
    }

    public  Collection<Employee> getApplicants(){return applicants;}

    @Override
    public String toString() {
        return "JobOffer{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                ", applicants=" + applicants +
                '}';
    }
}
