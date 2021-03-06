package dollar.store.linkedin;

import dollar.store.linkedin.Repositoy.EmployeeRepository;
import dollar.store.linkedin.Repositoy.EmployerRepository;
import dollar.store.linkedin.Repositoy.JobOfferRepository;
import dollar.store.linkedin.entities.Employee;
import dollar.store.linkedin.entities.Employer;
import dollar.store.linkedin.entities.JobOffer;
import dollar.store.linkedin.entities.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class LinkedinApplication {
    @Autowired
    JobOfferRepository postgre;

    @Autowired
    EmployerRepository companyRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List<JobOffer> allJobs = this.postgre.findAll();
        System.out.println("curr jobs: " + allJobs.size());
        Employee zobi = new Employee("Zobi", "McZobFace", "00990123");
        employeeRepo.save(zobi);
        Employer SAP = new Employer("SAP");
        this.companyRepo.save(SAP);

        JobOffer janitor = new JobOffer( "SAP", "janitor", JobType.IT, "Be Zobi", 5);
        this.postgre.save(janitor);
        SAP.addPosting(janitor);

        allJobs = this.postgre.findAll();
        List<Employer> allEmployers = this.companyRepo.findAll();
        System.out.println(allJobs.get(0).getCompany());
        System.out.println(allEmployers.get(0).toString());

        janitor.addApplicants(zobi);
        this.postgre.save(janitor);
    }
    public static void main(String[] args) {
        SpringApplication.run(LinkedinApplication.class, args);
        System.out.println("Started server with Chad DB");
    }

}
