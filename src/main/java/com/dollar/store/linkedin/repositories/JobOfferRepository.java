package com.dollar.store.linkedin.repositories;

import com.dollar.store.linkedin.entities.JobOffer;
import org.springframework.data.repository.CrudRepository;

public interface JobOfferRepository extends CrudRepository<JobOffer, Long> {
}
