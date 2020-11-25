package petclinicwednesday.ca.gbc.model;

import java.util.HashSet;
import java.util.Set;

public class Owner  extends Person {
    private Set<Pet> pet = new HashSet<>();
    private String address;
    private String city;
    private String telephone;
}
