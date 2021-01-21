package dollar.store.linkedin;

import dollar.store.linkedin.Repositoy.EmployerRepository;
import dollar.store.linkedin.Repositoy.JobOfferRepository;
import dollar.store.linkedin.entities.Employer;
import dollar.store.linkedin.entities.JobOffer;
import dollar.store.linkedin.entities.JobType;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;

import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class LinkedinApplication {
    @Autowired
    JobOfferRepository postgre;

    @Autowired
    EmployerRepository companyRepo;


    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List<JobOffer> allJobs = this.postgre.findAll();
        System.out.println("curr jobs: " + allJobs.size());

        Employer SAP = new Employer("SAP");
        this.companyRepo.save(SAP);

        JobOffer janitor = new JobOffer( "SAP", "janitor", JobType.IT, "Be Zobi", 5, SAP);
        this.postgre.save(janitor);
        SAP.addPosting(janitor);

        allJobs = this.postgre.findAll();
        List<Employer> allEmployers = this.companyRepo.findAll();
        System.out.println(allJobs.get(0).getCompany().toString());
        System.out.println(allEmployers.get(0).toString());

    }
    public static void main(String[] args) {
        SpringApplication.run(LinkedinApplication.class, args);
        System.out.println("hello world");
    }

}
