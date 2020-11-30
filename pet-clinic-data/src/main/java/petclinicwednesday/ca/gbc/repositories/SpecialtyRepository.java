package petclinicwednesday.ca.gbc.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinicwednesday.ca.gbc.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
