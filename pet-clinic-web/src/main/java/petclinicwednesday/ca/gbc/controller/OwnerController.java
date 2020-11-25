package petclinicwednesday.ca.gbc.controller;

import petclinicwednesday.ca.gbc.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    private String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        System.out.println(model);
        return "owners/index";
    }

    @RequestMapping("/find")
    private String findOwners() {
        return "owners/index";
    }
}
