package petclinicwednesday.ca.gbc.services.map;

import org.springframework.context.annotation.Profile;
import petclinicwednesday.ca.gbc.model.Pet;
import petclinicwednesday.ca.gbc.services.OwnerService;
import petclinicwednesday.ca.gbc.model.Owner;
import org.springframework.stereotype.Service;
import petclinicwednesday.ca.gbc.services.PetService;
import petclinicwednesday.ca.gbc.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            //does the petype exist?
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {//iterate through each pet
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    //does the pet exist
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
        }else{
            return null;
        }
        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
