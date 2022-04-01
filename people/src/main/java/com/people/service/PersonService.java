package com.people.service;

import com.people.dto.PersonDto;
import com.people.entity.Person;
import com.people.repository.PersonRepository;
import com.people.service.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void savePerson(PersonDto personDto) {
        personRepository.save(PersonMapper.personDtoToPerson(personDto));
    }

    public PersonDto getPersonById(Long id) {
        return PersonMapper.personToPersonDto(personRepository.getById(id));
    }

    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();


        List<PersonDto> personDtoList = new ArrayList<>();
        for (Person person : personList) {
            personDtoList.add(PersonMapper.personToPersonDto(person));
        }
        return personDtoList;
    }
}
