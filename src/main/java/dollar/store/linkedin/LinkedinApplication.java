package dollar.store.linkedin;

import dollar.store.linkedin.Repositoy.JobOfferRepository;
import dollar.store.linkedin.entities.JobOffer;
import dollar.store.linkedin.entities.JobType;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;

import java.util.List;

@SpringBootApplication
public class LinkedinApplication {
    @Autowired
    JobOfferRepository postgre;


    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List<JobOffer> allJobs = this.postgre.findAll();
        System.out.println("curr jobs: " + allJobs.size());

        JobOffer janitor = new JobOffer(123, "SAP", "janitor", JobType.IT, "Be Zobi", 5);
        janitor.setCompany("SAP");
        janitor.setTitle("janitor");

        System.out.println("add new offer");
        this.postgre.save(janitor);

        allJobs = this.postgre.findAll();
        System.out.println("curr jobs: " + allJobs.size());
        System.out.println("persisted enum: " + allJobs.get(0).getType());

    }
    public static void main(String[] args) {
        SpringApplication.run(LinkedinApplication.class, args);
        System.out.println("hello world");
    }

}
