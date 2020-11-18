package petclinicwednesday.ca.gbc.services;

import petclinicwednesday.ca.gbc.model.Vet;

public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lastName);
}
