package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.dto.PersonDTO;
import org.example.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;


    @GetMapping
    public String getAllPersons(Model model) {
        model.addAttribute("persons", service.getAllPersons());
        model.addAttribute("newPerson", new PersonDTO());
        return "persons/list";
    }

    @PostMapping
    public String createPerson(@ModelAttribute PersonDTO newPerson) {
        service.createPerson(newPerson);
        return "redirect:/persons";
    }
}