package com.dollar.store.linkedin.controllers;

import com.dollar.store.linkedin.entities.JobOffer;
import com.dollar.store.linkedin.repositories.JobOfferRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("job-offers")
public class JobOfferController {

    private JobOfferRepository repository;

    @GetMapping
    public Iterable<JobOffer> getAllJobOffers() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Optional<JobOffer> getJob(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public void createJobOffer(JobOffer offer) {
        repository.save(offer);
    }

    @DeleteMapping("{id}")
    public void deleteJobOffer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
