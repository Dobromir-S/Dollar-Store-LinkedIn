package dollar.store.linkedin.Repositoy;

import dollar.store.linkedin.entities.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> { }

