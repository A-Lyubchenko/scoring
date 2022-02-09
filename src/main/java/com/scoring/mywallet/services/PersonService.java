package com.scoring.mywallet.services;

import com.scoring.mywallet.domains.AdditionalContact;
import com.scoring.mywallet.domains.Person;
import com.scoring.mywallet.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService implements Crud<Person>{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(Person person) {

        return personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);

    }

    @Override
    public Person getById(UUID uuid) {
        Optional<Person> byId = personRepository.findById(uuid);
        return byId.orElse(null);
    }
}
