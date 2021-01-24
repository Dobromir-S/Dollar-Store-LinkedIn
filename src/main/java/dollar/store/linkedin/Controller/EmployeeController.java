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

@RestController
@RequestMapping("/test")
public class EmployeeController {

        @Autowired
        private EmployeeRepository employeeRepo;

        @Autowired
        private JobOfferRepository jobsRepo;

        @Autowired
        private EmployerRepository companyRepo;

        @GetMapping
        public List<Employee> findAll() {
            return employeeRepo.findAll();
        }

        @PostMapping
        public void createEmplyee(@RequestBody Employee e){
                employeeRepo.save(e);
        }

    }
