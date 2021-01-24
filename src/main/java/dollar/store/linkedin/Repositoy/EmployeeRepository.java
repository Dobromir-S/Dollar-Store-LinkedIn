package dollar.store.linkedin.Repositoy;

import dollar.store.linkedin.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
