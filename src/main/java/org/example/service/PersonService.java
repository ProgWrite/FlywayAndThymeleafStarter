package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.PersonDTO;
import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonService.class);
    private final PersonRepository repository;



    public PersonDTO createPerson(PersonDTO dto) {
        log.debug("Creating person: {}", dto);

        Person person = new Person();
        person.setName(dto.getName());
        person.setSurname(dto.getSurname());
        person.setAge(dto.getAge());

        Long id = repository.save(person);
        log.info("Person created with ID: {}", id);

        return new PersonDTO(id, person.getName(), person.getSurname(), person.getAge());
    }


    @Transactional(readOnly = true)
    public List<PersonDTO> getAllPersons() {
        return repository.findAll().stream()
                .map(person -> new PersonDTO(person.getId(), person.getName(), person.getSurname(), person.getAge()))
                .collect(Collectors.toList());
    }
}