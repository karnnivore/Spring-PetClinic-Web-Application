package petclinicwednesday.ca.gbc.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinicwednesday.ca.gbc.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String last_name);
}
