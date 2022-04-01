package com.people.service.mapper;

import com.people.dto.PersonDto;
import com.people.entity.Person;

public class PersonMapper {

    public static PersonDto personToPersonDto(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .age(person.getAge())
                .cars(person.getCars())
                .build();
    }

    public static Person personDtoToPerson(PersonDto personDto) {
        return Person.builder()
                .id(personDto.getId())
                .name(personDto.getName())
                .age(personDto.getAge())
                .cnp(personDto.getCnp())
                .cars(personDto.getCars())
                .build();
    }
}
