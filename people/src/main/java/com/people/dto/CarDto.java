package com.people.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.people.entity.Person;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDto {

    private Long id;

    private String color;

    private String brand;

    @JsonIgnore
    private Person person;

    private Long personId;
}
