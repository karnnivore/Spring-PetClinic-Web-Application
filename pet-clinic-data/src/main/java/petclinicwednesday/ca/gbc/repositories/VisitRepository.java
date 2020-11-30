package petclinicwednesday.ca.gbc.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinicwednesday.ca.gbc.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
