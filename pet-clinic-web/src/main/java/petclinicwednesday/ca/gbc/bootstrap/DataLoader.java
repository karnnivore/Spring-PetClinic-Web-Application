package petclinicwednesday.ca.gbc.bootstrap;

import petclinicwednesday.ca.gbc.model.Owner;
import petclinicwednesday.ca.gbc.model.PetType;
import petclinicwednesday.ca.gbc.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petclinicwednesday.ca.gbc.services.OwnerService;
import petclinicwednesday.ca.gbc.services.PetTypeService;
import petclinicwednesday.ca.gbc.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }
    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirst_name("Frodo");
        owner1.setLast_name("Baggins");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirst_name("Samwise");
        owner2.setLast_name("Gamgee");

        ownerService.save(owner2);

        System.out.println(ownerService.findAll());
        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirst_name("Bilbo");
        vet1.setLast_name("Baggins");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirst_name("Pippin");
        vet2.setLast_name("Took");

        vetService.save(vet2);

        System.out.println(vetService.findAll());
        System.out.println("Loaded Vets....");

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        System.out.println(petTypeService.findAll());
        System.out.println("Loaded PetTypes....");
    }
}
