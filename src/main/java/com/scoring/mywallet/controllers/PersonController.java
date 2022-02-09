package com.scoring.mywallet.controllers;

import com.scoring.mywallet.domains.AdditionalContact;
import com.scoring.mywallet.domains.Person;
import com.scoring.mywallet.services.AdditionalContactService;
import com.scoring.mywallet.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private AdditionalContactService additionalContactService;

    @GetMapping("/person")
    public List<Person> personList(){
       return personService.getAll();
    }
    @PostMapping("/person")
    public Person savePerson(@RequestBody Person person){
        return personService.save(person);
    }

    @GetMapping("/person/{id}")
    public Person getById(@PathVariable("id") UUID id){
        return personService.getById(id);

    }
@PutMapping("/person")
    public Person updatePerson(@RequestBody Person person){
        return personService.update(person);
    }
}
