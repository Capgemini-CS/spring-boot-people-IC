package com.people.controller;

import com.people.dto.PersonDto;
import com.people.service.PersonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.util.List;

@RequestMapping("/persons")
@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/")
    public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto personDto) {
        personService.savePerson(personDto);
        Logger.info("New person was created.");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<PersonDto> getPersonById(@RequestParam Long id) {
        Logger.info("Person with id = " + id + " was returned.");
        return ResponseEntity.ok().body(personService.getPersonById(id));
    }

    @GetMapping()
    public ResponseEntity<List<PersonDto>> getAll(){
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }
}
