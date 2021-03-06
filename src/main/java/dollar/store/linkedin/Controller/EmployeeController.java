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
@RequestMapping("/employee")
public class EmployeeController {

        @Autowired
        private EmployeeRepository employeeRepo;

        @Autowired
        private JobOfferRepository jobsRepo;

        @Autowired
        private EmployerRepository companyRepo;

        @GetMapping(value = "/{id}")
        public Optional<Employee> getEmployee(@PathVariable("id") Long id) {
            return employeeRepo.findById(id);
        }

        @DeleteMapping (value = "/{id}")
        public void deleteEmployee(@PathVariable("id") Long id) {
                 employeeRepo.deleteById(id);
        }

        @PutMapping
        public void updateEmployee(@RequestBody Employee e) {
                employeeRepo.save(e);
        }

        @GetMapping
        public List<Employee> findAll() {
                return employeeRepo.findAll();
        }

        @PostMapping
        public void createEmployee(@RequestBody Employee e){
                employeeRepo.save(e);
        }

    }
