package petclinicwednesday.ca.gbc.controller;

import petclinicwednesday.ca.gbc.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets"})
    private String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        System.out.println(model);
        return "vets/index";
    }

    @RequestMapping("/vets.html")
    private String errorVets() {
        return "vets/index";
    }
}
