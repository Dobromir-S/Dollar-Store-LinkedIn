package dollar.store.linkedin.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "employer", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    Collection<JobOffer> listings = new LinkedHashSet<>();

    public Employer(String name) {
        this.name = name;
    }

    public Employer() {

    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listings=" + listings +
                '}';
    }

    public void addPosting(JobOffer job){
        listings.add(job);
    }

}
