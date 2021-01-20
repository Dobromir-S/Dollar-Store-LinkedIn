package dollar.store.linkedin.entities;

import javax.persistence.*;

@Entity
@Table(name = "joboffer")
public class JobOffer {
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
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

}
