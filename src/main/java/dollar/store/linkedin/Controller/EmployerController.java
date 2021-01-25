package dollar.store.linkedin.Controller;

import dollar.store.linkedin.Repositoy.EmployeeRepository;
import dollar.store.linkedin.Repositoy.EmployerRepository;
import dollar.store.linkedin.Repositoy.JobOfferRepository;
import dollar.store.linkedin.entities.Employee;
import dollar.store.linkedin.entities.Employer;
import dollar.store.linkedin.entities.JobOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employer")
public class EmployerController {

        @Autowired
        private EmployeeRepository employeeRepo;

        @Autowired
        private JobOfferRepository jobsRepo;

        @Autowired
        private EmployerRepository companyRepo;

        @GetMapping(value = "/{id}")
        public Optional<Employer> getEmployer(@PathVariable("id") Long id) {
            return companyRepo.findById(id);
        }

        @DeleteMapping (value = "/{id}")
        public void deleteEmployer(@PathVariable("id") Long id) {
                 companyRepo.deleteById(id);
        }

        @PutMapping
        public void updateEmployer(@RequestBody Employer e) {
                companyRepo.save(e);
        }

        @GetMapping
        public List<Employer> findAll() {
                return companyRepo.findAll();
        }

        @PostMapping
        public void createEmployer(@RequestBody Employer e){
                companyRepo.save(e);
        }

        @PostMapping(value = "/{id}")
        public void postJob(@PathVariable("id") Long id ,@RequestBody JobOffer j){
                Employer e = companyRepo.findById(id).get();
                jobsRepo.save(j);
                e.addPosting(j);
                companyRepo.save(e);
        }

    }
