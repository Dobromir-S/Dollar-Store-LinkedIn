package dollar.store.linkedin.Controller;

import dollar.store.linkedin.Repositoy.EmployeeRepository;
import dollar.store.linkedin.Repositoy.EmployerRepository;
import dollar.store.linkedin.Repositoy.JobOfferRepository;
import dollar.store.linkedin.entities.Employee;
import dollar.store.linkedin.entities.JobOffer;
import dollar.store.linkedin.entities.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jobs")
public class JobOfferController {

        @Autowired
        private EmployeeRepository employeeRepo;

        @Autowired
        private JobOfferRepository jobRepo;

        @Autowired
        private EmployerRepository companyRepo;

        @GetMapping
        public List<JobOffer> findAll() {
                return jobRepo.findAll();
        }

        @GetMapping(value = "/{id}")
        public Optional<JobOffer> getListing(@PathVariable("id") Long id) {
            return jobRepo.findById(id);
        }

        @DeleteMapping (value = "/{id}")
        public void deleteJob(@PathVariable("id") Long id) {
                 jobRepo.deleteById(id);
        }

        @PutMapping
        public void updateJob(@RequestBody JobOffer e) {
                jobRepo.save(e);
        }

        @GetMapping(value = "/category")
        public List<JobOffer> findAllByCategory(@RequestBody String jobType) {
                return jobRepo.findAll().stream().filter(j -> j.getType().equals(JobType.valueOf(jobType))).collect(Collectors.toList());
        }

        @GetMapping(value = "/employer/{id}")
        public List<JobOffer> findAllByCategory(@PathVariable Long id) {
                return (List<JobOffer>) companyRepo.findById(id).get().getListings();
        }

        @PostMapping(value = "/apply/{id}")
        public void applyToCompany(@PathVariable Long id, @RequestBody Employee chad) {
                System.out.println(chad.toString());
                JobOffer j = jobRepo.findById(id).get();
                Employee e = employeeRepo.save(chad);
                j.addApplicants(e);
                jobRepo.save(j);
        }

        @PostMapping
        public void createJobOffer(@RequestBody JobOffer e){
                System.out.println(e.toString());
                jobRepo.save(e);
        }
    }