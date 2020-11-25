package petclinicwednesday.ca.gbc.bootstrap;

import petclinicwednesday.ca.gbc.model.Owner;
import petclinicwednesday.ca.gbc.model.Pet;
import petclinicwednesday.ca.gbc.model.PetType;
import petclinicwednesday.ca.gbc.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petclinicwednesday.ca.gbc.services.OwnerService;
import petclinicwednesday.ca.gbc.services.PetTypeService;
import petclinicwednesday.ca.gbc.services.VetService;

import java.time.LocalDate;

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
        //load pettypes
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        System.out.println(petTypeService.findAll());
        System.out.println("Loaded PetTypes....");

        //load owners
        Owner owner1 = new Owner();
        owner1.setFirst_name("Frodo");
        owner1.setLast_name("Baggins");
        owner1.setAddress("123 Fellowship street");
        owner1.setCity("Minas Anor");
        owner1.setTelephone("647-123-45657");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirst_name("Samwise");
        owner2.setLast_name("Gamgee");
        owner2.setAddress("125 Fellowship Street");
        owner2.setCity("Minas Anor");
        owner2.setTelephone("647-765-4321");

        ownerService.save(owner2);

        System.out.println(ownerService.findAll());
        System.out.println("Loaded Owners");

        //load pets
        Pet frodosPet = new Pet();
        frodosPet.setName("Fido");
        frodosPet.setPetType(saveDogPetType);
        frodosPet.setBirthdate(LocalDate.now());
        frodosPet.setOwner(owner1);
        owner1.getPets().add(frodosPet);

        Pet samsPet = new Pet();
        samsPet.setName("Mimi");
        samsPet.setPetType(saveCatPetType);
        samsPet.setBirthdate(LocalDate.now());
        samsPet.setOwner(owner2);
        owner2.getPets().add(frodosPet);

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


    }
}
