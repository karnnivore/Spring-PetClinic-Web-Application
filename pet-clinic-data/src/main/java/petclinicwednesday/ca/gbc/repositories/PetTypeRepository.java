package petclinicwednesday.ca.gbc.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinicwednesday.ca.gbc.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
