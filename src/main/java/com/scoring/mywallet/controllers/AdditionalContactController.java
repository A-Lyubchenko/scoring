package com.scoring.mywallet.controllers;

import com.scoring.mywallet.domains.AdditionalContact;
import com.scoring.mywallet.services.AdditionalContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api")
public class AdditionalContactController {

    @Autowired
    private AdditionalContactService additionalContactService;

    @GetMapping("/person")
    public List<AdditionalContact> personList(){
        return additionalContactService.getAll();
    }
    @PostMapping("/person")
    public AdditionalContact savePerson(@RequestBody AdditionalContact additionalContact){
        return additionalContactService.save(additionalContact);
    }

    @GetMapping("/person/{id}")
    public AdditionalContact getById(@PathVariable("id") UUID id){
        return additionalContactService.getById(id);

    }
    @PutMapping("/person")
    public AdditionalContact updatePerson(@RequestBody AdditionalContact additionalContact){
        return additionalContactService.update(additionalContact);
    }
}
