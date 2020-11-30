package petclinicwednesday.ca.gbc.bootstrap;

import petclinicwednesday.ca.gbc.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petclinicwednesday.ca.gbc.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) loadData();
    }

    private void loadData() {
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

        //Load Specialities
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");

        Specialty savedRadiology = specialtiesService.save(radiology);
        Specialty savedDentistry = specialtiesService.save(dentistry);
        Specialty savedSurgery = specialtiesService.save(surgery);

        //Load Vets
        Vet vet1 = new Vet();
        vet1.setFirst_name("Bilbo");
        vet1.setLast_name("Baggins");
        vet1.getSpecialties().add(radiology);
        vet1.getSpecialties().add(dentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirst_name("Pippin");
        vet2.setLast_name("Took");
        vet2.getSpecialties().add(surgery);

        vetService.save(vet2);

        System.out.println(vetService.findAll());
        System.out.println("Loaded Vets....");

        //inject visits
        Visit catVisit = new Visit();
        catVisit.setPet(samsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sick Cat");

        visitService.save(catVisit);
        System.out.println("Loaded Visits...");
    }
}
