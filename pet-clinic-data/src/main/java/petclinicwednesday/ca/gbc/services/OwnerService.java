package petclinicwednesday.ca.gbc.services;

import petclinicwednesday.ca.gbc.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
