package petclinicwednesday.ca.gbc.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinicwednesday.ca.gbc.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
