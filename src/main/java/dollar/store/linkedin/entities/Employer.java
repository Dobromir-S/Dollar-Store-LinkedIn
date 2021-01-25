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
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    String name;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    Collection<JobOffer> listings = new LinkedHashSet<>();

    public Employer(String name) {
        this.name = name;
    }

    public Employer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<JobOffer> getListings() {
        return listings;
    }

    public void setListings(Collection<JobOffer> listings) {
        this.listings = listings;
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
